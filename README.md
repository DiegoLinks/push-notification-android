# push-notification-android
Basic solution for push notification in android apps.

Gradle:
	
	ModuleApp:
		
		Implementation firebase-messaging latest version
		apply plugin google-services
		
	Project:
	
		Classpath google-services latest

Class:
	
	IdManager
	MyFirebaseMessagingService
	Constants (with basic configurations, copy in our project)

Mainifest:
	
	Internet Permission
	
	Services for Classes:
	
		IdManager
		MyFirebaseMessagingService
	
	Metadatas:
	
		default notification icon
		default notification color
		default notification channel id

Documentation and “step by step” from Firebase:

https://firebase.google.com/docs/cloud-messaging/android/client

Note: To send a notification, you need to set up an account for your application in Firebase or you will need to setup a server for this.
