package rukina.jaycee.utils;

public interface Config {

	// used to share GCM regId with application server - using php app server
//	static final String APP_SERVER_URL = "http://budnetdesign.in/jaycee/api/login?";
		static final String APP_SERVER_URL = "http://budnetdesign.in/jaycee/api/login?username=%s&password=%s";
	static final String REG_USER = "http://budnetdesign.in/jaycee/api/register?name=%s&mobile_no=%s&username=%s&password=%s&gcm_registration_id=%s";


	// GCM server using java
	// static final String APP_SERVER_URL =
	// "http://192.168.1.17:8080/GCM-App-Server/GCMNotification?shareRegId=1";

	// Google Project Number
	static final String GOOGLE_PROJECT_ID = "21375701524";
	static final String MESSAGE_KEY = "message";

	public static String PARAM_MESSAGE = "msg";
	public static final String GET_SIGN_UP_URL = "http://hobbistan.com/app/hobbistan/api.php?";
	public static final String PARAMS_FUNC_NAME = "func_name";
	public static final String PARAMS_USER_NAME = "username";

	// Alert Dialog Constants
	public static String ALERT_DIALOG_TITLE = "alertDialogTitle";
	public static String ALERT_DIALOG_MESSAGE = "alertDialogMessage";
	public static String ALERT_DIALOG_TAG = "alertDialogTag";
	public static String ALERT_DIALOG_INPUT_HINT = "alert_dialog_input_hint";
	public static String ALERT_DIALOG_POS_BUTTON = "alert_dialog_pos_button";
	public static String ALERT_DIALOG_NEG_BUTTON = "alert_dialog_neg_button";


}