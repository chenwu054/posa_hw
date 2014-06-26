Answers:

1. to disable direct initiation from VulnCheck.apk, a customized permission is defined.
It is called edu.vuum.mocca.iRememberSecurityPermission as shown in the Manifest.xml file.
It is in the Login.activity
All apps that are allowed to call iRemember must have this permission.

2. To avoid Geo Location from VulnCheck.apk. CreateStoryActivity.java is modified by commenting line 382: Log.d(LOG_TAG, "setLocation =" + location); as shown in the CreateStoryActivity.java

3. To protect Audio Record, android.permission.RECORD_AUDIO permission is inserted in the SoundRecordActivity in the Manifest.xml file

4. To protect the Login file, the securityLevel is set to StorageUtilities.SECURITY_PRIVATE instead of MAX_SECURITY to store the Login file internally. This is in the getLoginFile method, right below //line 48

All the changes in the Manifest.xml are commented and highlighted by the eye-catching brackets: <!-!!!!!! !!!!!!!——> 