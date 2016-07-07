package com.joandilee;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.telephony.TelephonyManager;
import android.content.Context;
import android.util.Log;

public class imeiplugin extends CordovaPlugin {
	@Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        try {
            if (action.equals("getImei")) {
                this.DeviceImeiNumber(callbackContext);
            }
            return true;
        } catch (Exception e){
            callbackContext.error(e.getMessage());
            return false;
        }
    }

    public void DeviceImeiNumber(CallbackContext callbackContext) {
    	try {
            Context context=this.cordova.getActivity().getApplicationContext();

            TelephonyManager tManager = (TelephonyManager)cordova.getActivity().getSystemService(context.TELEPHONY_SERVICE);
            callbackContext.success(tManager.getDeviceId());
    	} catch (Exception e){
            callbackContext.error(e.getMessage());
            return false;
        }
    }

    private void getImei(String message, CallbackContext callbackContext) {
        if (message != null && message.length() > 0) {
            callbackContext.success(message);
        } else {
            callbackContext.error("Expected one non-empty string argument.");
        }
    } 
} 
