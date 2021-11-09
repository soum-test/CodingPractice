package utility;

import java.net.URI;
import java.net.URISyntaxException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import microsoft.exchange.webservices.data.core.ExchangeService;
import microsoft.exchange.webservices.data.core.enumeration.misc.ExchangeVersion;
import microsoft.exchange.webservices.data.core.enumeration.property.WellKnownFolderName;
import microsoft.exchange.webservices.data.core.service.folder.Folder;
import microsoft.exchange.webservices.data.core.service.item.Item;
import microsoft.exchange.webservices.data.credential.ExchangeCredentials;
import microsoft.exchange.webservices.data.credential.WebCredentials;
import microsoft.exchange.webservices.data.property.complex.EmailAddress;
import microsoft.exchange.webservices.data.property.complex.FolderId;
import microsoft.exchange.webservices.data.property.complex.Mailbox;
import microsoft.exchange.webservices.data.search.FolderView;

public class EmailUtility {
	private ExchangeService service;
	private static final String EXCHANGE_URI = "";
	private String sUserName = "";
	private String sPassword = "";
	
	private Item emailItem = null;
	private Folder folder = null;
	private Document htmlDoc = null;
	
	private static final String ATTACHMENT_PATH = "Attachments";
	private static final int NO_OF_EMAILS=100;
	private String sSharedEmailboxAddress="";
	
	/**
	 * Constructor to connect to Outlook using userName and password
	 * @param sUserName
	 * @param sPassword
	 * @param domain
	 * @throws EmailException
	 */
	public EmailUtility(String sUserName, String sPassword, Domain domain) throws EmailException{
		this.sUserName = sUserName;
		this.sPassword = sPassword;
		service = new ExchangeService(ExchangeVersion.Exchange2013);
		
		try {
			service.setUrl(new URI(EXCHANGE_URI));
			ExchangeCredentials credentials = new WebCredentials(sUserName, sPassword, domain.toString());
			service.setCredentials(credentials);
		}catch (URISyntaxException e) {
			new EmailException("Invalid URI\n" + e.getStackTrace());
		}
				
	}
	
	/**
	 * Constructor to connect to Outlook using userName and password
	 * @param sUserName
	 * @param sPassword
	 * @param domain
	 * @throws EmailException
	 */
	public EmailUtility(String sUserName, String sPassword, Domain domain, String sSharedMailBoxAddress) throws EmailException{
		this(sUserName, sPassword, domain);
		this.sSharedEmailboxAddress = sSharedMailBoxAddress;
				
	}
	
	/**
	 * Constructor to connect to Outlook using userName and password
	 * @param sUserName
	 * @param sPassword
	 * @param domain
	 * @throws EmailException
	 */
	public EmailUtility(String sUserName, String sPassword) throws EmailException{
		this(sUserName, sPassword, Domain.ABCNT);
	}
	
	/**
	 * Constructor to connect to Outlook using userName and password
	 * @param sUserName
	 * @param sPassword
	 * @param domain
	 * @throws EmailException
	 */
	public EmailUtility(String sUserName, String sPassword,String sSharedMailBoxAddress) throws EmailException{
		this(sUserName, sPassword, Domain.ABCNT);
		this.sSharedEmailboxAddress = sSharedMailBoxAddress;
				
	}
	
	/**
	 * Constructor to connect to Outlook using email address and password
	 * @param sUserName
	 * @param sPassword
	 * @param domain
	 * @throws EmailException
	 */
	public EmailUtility(EmailAddress emailAddress, String sPassword) throws EmailException{
		service = new ExchangeService(ExchangeVersion.Exchange2013);
		
		try {
			service.setUrl(new URI(EXCHANGE_URI));
			ExchangeCredentials credentials = new WebCredentials(emailAddress.getAddress(), sPassword);
			service.setCredentials(credentials);
		}catch (URISyntaxException e) {
			new EmailException("Invalid URI\n" + e.getStackTrace());
		}catch (Exception e) {
			new EmailException("Invalid email address\n" + e.getStackTrace());
		}
	}
	
	/**
	 * Constructor to connect to Outlook using email address and password
	 * @param sUserName
	 * @param sPassword
	 * @param domain
	 * @throws EmailException
	 */
	public EmailUtility(EmailAddress emailAddress, String sPassword,String sSharedMailBoxAddress) throws EmailException{
			this(emailAddress.getAddress(), sPassword);
			this.sSharedEmailboxAddress = sSharedMailBoxAddress;
	}
	
	/**
	 * Enumeration for email components to select
	 * @author Soumitra
	 *
	 */
	public enum EmailComponent {
		SUBJECT,
		FROM_ADDRESS,
		FROM_NAME,
		TO_ADDRESS,
		TO_NAMES,
		CC_ADDRESS,
		CC_NAMES,
		BCC_ADDRESS,
		BODY_TEXT,
		ATTCHMENTS,
		CREATED_DATETIME,
		SENT_DATETIME,
		RECEIVED_DATETIME;
	}
	
	/**
	 * Enumeration for tagname
	 * @author Soumitra
	 *
	 */
	public enum Tag {
		ITALIC,
		BOLD,
		UNDERLINE,
		UNORDERED_LIST,
		ORDERED_LIST,
		TABLE,
		LINKS,
		OTHER;
	}
	
	/**
	 * Enumeration for the domain
	 * @author Soumitra
	 *
	 */
	public enum Domain{
		ABCNT("ABCNT"),
		ABCUAT("ABCUAT"),
		ABCQA("ABCQA");
		
		private final String sDomain;
		
		Domain(final String sDomain){
			this.sDomain = sDomain;
		}
		
		@Override
		public String toString() {
			return this.sDomain;
		}
	}
	
	/**
	 * Method to set default email item
	 * @param emailItem
	 */
	public void setEmailItem(Item emailItem) {
		this.emailItem = emailItem;
		
		this.htmlDoc = (Document) Jsoup.parse(this.getHTMLBody(emailItem));
	}
	
	/**
	 * Method to get the HTML document object of pre-selected email
	 * @return
	 */
	public Document getHTMLDocument() {
		return this.htmlDoc;
	}
	
	public Document getHTMLDocument(Item emailItem) {
		return Jsoup.parse(this.getHTMLBody(emailItem));
	}
	
	/**
	 * Method to get HTML body of the email
	 * @param mailItem
	 * @return HTML body of the email
	 */
	public String getHTMLBody(Item mailItem) {
		 try {
			 mailItem.load();
			 return mailItem.getBody().toString();
		 }catch (Exception e) {
			return "<html><body></body></html>";
		}
	}
	
	/**
	 * Method to set default folder
	 * @param sUserDefinedFolderName
	 */
	public void setFolder(String sUserDefinedFolderName) {
		this.folder = this.getUserDefinedFolder(sUserDefinedFolderName);
	}
	
	/**
	 * Method to get user defined folder
	 * @param sFolderName
	 * @return Folder object
	 */
	private Folder getUserDefinedFolder(String sFolderName) {
		try {
			
			Folder root;
			
			if(!this.sSharedEmailboxAddress.equals("")) {
				FolderId folderId = new FolderId(WellKnownFolderName.MsgFolderRoot, Mailbox.getMailboxFromString(this.sSharedEmailboxAddress));
				root = Folder.bind(this.service, folderId);
			}else {
				root = Folder.bind(this.service, WellKnownFolderName.MsgFolderRoot);
			}
			
			for(Folder folder : root.findFolders(new FolderView(100))) {
				
				if(folder.getDisplayName().equals(sFolderName)) {
					return folder;
				}
				
				if(folder.getDisplayName().equals("Folders")) {					
					for(Folder inFolder: folder.findFolders(new FolderView(100))) {						
						if(inFolder.getDisplayName().equals(sFolderName)) {
							return folder;
						}
					}
				}
			}
		}catch (Exception e) {
		}
		
		return null;
	}
	
	/**
	 * 
	 * @author Soumitra
	 *
	 */
	public class EmailException extends Exception{
		/**
		 * Serial Version ID
		 */
		private static final long serialVersionUID = 1L; 
		
		/**
		 * Constructor to set exception message
		 * @param sMessage
		 */
		public EmailException(String sMessage) {
			super(sMessage);
		}
	}
}


