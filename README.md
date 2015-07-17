App Architecture : 
==================

WebView-Mail

Easy to use WebView to display mail Like K9 and Gmail
	

	
	1. Client-Server Architecture : 
		a) JSON-RPC (Link to library : http://software.dzhuvinov.com/json-rpc-2.0-client.html) :
		
			![alt tag](https://pp.vk.me/c624716/v624716717/3ad2d/ToCM0utgid0.jpg)

			This Java library provides a simple class for establishing client sessions to JSON-RPC 2.0 servers.

				- Create a new session to the desired JSON-RPC 2.0 server URL.
			
				- Use the session object to send JSON-RPC 2.0 requests to the server and receive the corresponding responses. Sending of JSON-RPC 2.0 notifications is also supported.

			The JSON-RPC 2.0 messages are transported with HTTP(S) POST.

			Apart from the basic functionality - sending JSON-RPC 2.0 requests + notifications and receiving responses, this library also has a number of configuration options:

				- Customise the "Content-Type" header in HTTP POST requests.
				
				- Set an "Origin" header in HTTP POST requests to simulate Cross-Origin Resource Sharing (CORS) requests from a browser.
				
				- Accept HTTP cookies, for JSON-RPC services that use this out-of-channel method for keeping track of user sessions.
				
				- Customise the allowable "Content-Type" header values in HTTP POST responses.
				
				- Set an HTTP proxy.
				
				- Enable HTTP response compression using GZIP and DEFLATE content encoding.
				
				- Preserve the parse order of JSON object members in JSON-RPC 2.0 response results (for human facing clients, such as the JSON-RPC 2.0 Shell ).
				
				- Ignore version 2.0 checks when parsing responses to allow client sessions to older JSON-RPC (1.0) servers.
				
				- Parse non-standard attributes in JSON-RPC 2.0 responses.
				
				- Set timeouts for HTTP server connect and read operations.
				
				- Trust all X.509 server certificates (for secure HTTPS connections), including self-signed certificates.
				
			Requirements

				- Supported JSON-RPC protocol version: 2.0
				- JSON-RPC 2.0 transport mechanism: HTTP (POST)
				- Java Runtime: 1.5+
				- Package dependencies:
					- JSON-RPC 2.0 Base for creating, serialising and parsing JSON-RPC 2.0 messages (also available on this web site, JAR included in the download package for convenience).
					- JSON Smart for encoding and decoding JSON text (JAR included in the download package for convenience).

		b) REST (Link to library : https://github.com/koush/ion) :
			
			Features

			Asynchronously download :
				- Images into ImageViews or Bitmaps (animated GIFs supported too)
				- JSON (via Gson)
				- Strings
				- Files
				- Java types using Gson
				
			Easy to use Fluent API designed for Android
				- Automatically cancels operations when the calling Activity finishes
				- Manages invocation back onto the UI thread
				- All operations return a Future and can be cancelled
    
			HTTP POST/PUT :
				- text/plain
				- application/json - both JsonObject and POJO
				- application/x-www-form-urlencoded
				- multipart/form-data
    
			Transparent usage of HTTP features and optimizations :
				- SPDY and HTTP/2
				- Caching
				- Gzip/Deflate Compression
				- Connection pooling/reuse via HTTP Connection: keep-alive
				- Uses the best/stablest connection from a server if it has multiple IP addresses
				- Cookies
    
			View received headers
			
			Grouping and cancellation of requests
			
			Download progress callbacks
			
			Supports file:/, http(s):/, and content:/ URIs
			
			Request level logging and profiling
			
			Support for proxy servers like Charles Proxy to do request analysis
			
			Based on NIO and AndroidAsync
			
			Ability to use self signed SSL certificates
			
		c) Implementation inside app : 
			
			Communication between threads through ResultReceiver
			
			![alt tag](https://pp.vk.me/c624716/v624716717/3ad36/7GOPylTXYXw.jpg)
			
			A little about architecture approach (Service+Thread+BroadcastReceiver) : 
			
			For the organization of a separate stream I chose IntentService. 
			Why him and not a simple Service? 
			Because IntentService admission to his commands automatically begins to perform a method onHandleIntent (Intent intent) to separate from the UI thread.
			Simple Service does not allow this because it runs in the main flow.
			Communication between the Activity and IntentService-th will be using Intents.
			
			All requests to the server are handled in the above mentioned architecture.
			
			![alt tag](https://pp.vk.me/c624716/v624716717/3ad3d/crefs70gJhk.jpg)
			![alt tag](https://pp.vk.me/c624716/v624716717/3ad44/6p47-AO3X6w.jpg)
			
			![alt tag](https://pp.vk.me/c624716/v624716717/3ad4c/fxim4HGyyFI.jpg)
			
	1. DB Architecture :
		
		a) Data saving via Content Provider (Link : http://developer.android.com/guide/topics/providers/content-providers.html) or (Service + Content Provider + UI) 
		
		MVC in Android
		![alt tag](https://pp.vk.me/c624716/v624716717/3ad1f/998kZE1AmnQ.jpg)
		
		![alt tag](https://pp.vk.me/c624716/v624716717/3ad54/fPn_zoBTt-g.jpg)
		
		Content Provider is a wrapper, which includes data. 
		Content Provider is a way to share the common areas of your application data.
		We use SQLiteOpenHelper for database management, and implement methods of query, insert, update, delete class ContentProvider.
		
		![alt tag](https://pp.vk.me/c624716/v624716717/3ad5b/yNa4bq2JG2Q.jpg)
		
		![alt tag](https://pp.vk.me/c624716/v624716717/3ad26/CdTjyN3z_II.jpg)
		
		b) Data Synchronization (Info Link : http://www.c99.org/2010/01/23/writing-an-android-sync-provider-part-2/ Info Link : http://remotexpert.net/2013/10/why-implement-android-syncadapter/)
		
		![alt tag](https://pp.vk.me/c624716/v624716717/3ad62/vCDNy2nR6bw.jpg)
		
		To use this method of synchronization is necessary to create a particular type of an account specifically for your suggestions (if accounts are available, for example, Google accounts are not suitable).
		This account will be available under Settings / Accounts & Sync.
		Create (and delete) your account will be possible not only because of your application, but also in this section.
		
		What is good (+) and bad (-) synchronization via SyncAdapter compared with ASyncTask?
		
		(+) Following the standards (your application in the list of all synchronizing applications)
		(+) Support for multiple accounts and logs
		(+) Easy to implement automatic synchronization (when everything else has been written)
		(+) Automatic synchronization with the appearance of Internet connection
		(+) Ease in synchronization with standard bases (contacts, calendar etc.)
		(-) The need to create an account
		(-) Lack of complete documentation
		(-) Need Android 2.2 or higher for automatic periodic synchronization
		(-) The need to create its ContentProvider'a
		
		
	
	





