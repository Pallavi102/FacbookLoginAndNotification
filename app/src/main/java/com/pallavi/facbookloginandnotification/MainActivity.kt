package com.pallavi.facbookloginandnotification

import android.R
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.facebook.CallbackManager
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.facebook.FacebookSdk
import com.facebook.login.LoginResult
import com.facebook.login.widget.LoginButton
import com.google.firebase.auth.FirebaseAuth
import com.pallavi.facbookloginandnotification.databinding.ActivityMainBinding
import java.util.*


class MainActivity : AppCompatActivity() {

    var callbackManager = CallbackManager.Factory.create()
    lateinit var binding: ActivityMainBinding
    var fbAuth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //SHA1: E2:B6:66:69:F5:5A:31:C0:41:6C:54:B3:A0:04:83:47:DB:AD:CD:48
        //SHA-256: 9B:5D:30:81:11:BA:1C:2F:50:22:4A:07:FE:EE:9D:8F:A6:2C:BF:5F:C7:19:F5:68:E2:DA:C2:DD:36:01:B3:9A

        //generated   4rZmafVaMcBBbFSzoASDR9utzUg=

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        FacebookSdk.sdkInitialize(this)
        binding.loginButton.setReadPermissions(Arrays.asList("email"))
        // If you are using in a fragment, call loginButton.setFragment(this);
        val EMAIL = "email"
        // If you are using in a fragment, call loginButton.setFragment(this);

        // Callback registration
        // If you are using in a fragment, call loginButton.setFragment(this);

        // Callback registration
        binding.loginButton.registerCallback(callbackManager, object : FacebookCallback<LoginResult> {
          override  fun onSuccess(loginResult: LoginResult) {
              System.out.println(" in login result ${loginResult.accessToken}")
                // App code
            }

            override fun onCancel() {
                // App code
            }

            override fun onError(exception: FacebookException) {
                // App code
            }
        })
    }
}
