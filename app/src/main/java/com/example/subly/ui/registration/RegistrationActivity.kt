package com.example.subly.ui.registration
import android.content.Context
import android.content.res.ColorStateList
import android.content.res.ColorStateList.valueOf
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.CheckBox
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.getColor
import com.example.subly.R
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.example.subly.models.UserInfo
import com.example.subly.ui.concrete.ColorChangeUITextImpl
import com.example.subly.ui.concrete.ErrorUIAlert
import com.example.subly.ui.concrete.SuccessUIAlert
import com.example.subly.ui.service.colorHandler.TextColorModifier
import com.example.subly.ui.concrete.WarningUIAlert
import com.example.subly.ui.service.inputHandler.EmailAddressValidationHandler
import utils.RegexPatterns
import com.example.subly.ui.service.inputHandler.MobileNumberValidationHandler
import com.example.subly.ui.service.inputHandler.NameValidationHandler
import com.example.subly.ui.service.inputHandler.PasswordValidationHandler

/**
 * Registration Activity that hosts the user registration form.
 */
class RegistrationActivity : AppCompatActivity() {
    private lateinit var tvStrengthValue: TextView
    private lateinit var ivShield: ImageView
    private lateinit var tvPasswordRequirement: TextView
    private lateinit var tvPasswordRequirement2: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Inflating the XML layout
        setContentView(R.layout.activity_register)

        tvStrengthValue = findViewById(R.id.tvStrengthValue)
        ivShield = findViewById(R.id.ivShield)
        tvPasswordRequirement = findViewById(R.id.tvPasswordRequirement)
        tvPasswordRequirement2 = findViewById(R.id.tvPasswordRequirement_2)

        val tilFirstName = findViewById<TextInputLayout>(R.id.tilFirstName)
        val tilLastName = findViewById<TextInputLayout>(R.id.tilLastName)
        val tilEmailAddress = findViewById<TextInputLayout>(R.id.tilEmailAddress)
        val tilPhone = findViewById<TextInputLayout>(R.id.tilPhone)
        val btnCreateAccount = findViewById<MaterialButton?>(R.id.btnCreateAccount)
        val btnBack = findViewById<ImageButton?>(R.id.btnBack)
        val cbTerms = findViewById<CheckBox>(R.id.cbTerms)

        val tfFirstName: TextInputEditText = findViewById(R.id.tfFirstName)
        val tfLastName: TextInputEditText = findViewById(R.id.tfLastName)
        val tfEmailAddress: TextInputEditText = findViewById(R.id.tfEmailAddress)
        val tfPhone: TextInputEditText = findViewById(R.id.tfPhone)
        val tfPassword: TextInputEditText = findViewById(R.id.tfPassword)

        ColorChangeUITextImpl().colorChangeUIText(
            this,
            tfFirstName,
            tilFirstName,
            RegexPatterns.NAME_REGEX
        )
        ColorChangeUITextImpl().colorChangeUIText(
            this,
            tfFirstName,
            tilFirstName,
            RegexPatterns.NAME_REGEX
        )
        ColorChangeUITextImpl().colorChangeUIText(
            this,
            tfLastName,
            tilLastName,
            RegexPatterns.NAME_REGEX
        )
        ColorChangeUITextImpl().colorChangeUIText(
            this,
            tfEmailAddress,
            tilEmailAddress,
            RegexPatterns.EMAIL_REGEX
        )
        ColorChangeUITextImpl().colorChangeUIText(
            this,
            tfPhone,
            tilPhone,
            RegexPatterns.NUMBER_REGEX
        )
        updatePasswordUI(tfPassword, tvStrengthValue)


        btnCreateAccount.setOnClickListener {

            val user = UserInfo(
                firstName = tfFirstName.text.toString().trim(),
                lastName = tfLastName.text.toString().trim(),
                email = tfEmailAddress.text.toString().trim(),
                phone = tfPhone.text.toString().trim(),
                password = tfPassword.text.toString().trim()
            )
            // We validate all fields so the user sees all errors at once
            val isFirstValid = NameValidationHandler().setValidationType(user.firstName)
            val isLastValid = NameValidationHandler().setValidationType(user.lastName)
            val isEmailValid = EmailAddressValidationHandler().setValidationType(user.email)
            val isPhoneValid = MobileNumberValidationHandler().setValidationType(user.phone)
            val isPassValid = PasswordValidationHandler().setValidationType(user.password)
            val isAccepted = cbTerms.isChecked

            // 3. Final check
            if (isFirstValid && isLastValid && isEmailValid && isPhoneValid && isPassValid) {
                if (!isAccepted) {
                    Toast.makeText(this, "Please accept terms", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }
                // Proceed with Registration
                Log.d("REGISTRATION", "All inputs valid. Creating account...")
            } else {
                Toast.makeText(this, "Please check form", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
        }
    }

    fun updatePasswordStrength(password: String, textView: TextView?) {

        if (password.isEmpty()) {
            return textView?.text = "Weak"
        }
        var score = 0
        if (password.length >= 8) {
            score++
        }

        if (password.matches(".*[a-z].*".toRegex())) {
            score++
        }


        if (password.matches(".*[A-Z].*".toRegex())) {
            score++
        }


        if (password.matches(".*\\d.*".toRegex())) {
            score++
        }

        if (password.matches(".*[^a-zA-Z0-9].*".toRegex())) {
            score++
        }
        updateStrengthUI(score)
    }

    fun weakStatus() {
        tvStrengthValue.text = "Weak"
        ErrorUIAlert().tvAlert(
            this,
            tvStrengthValue,
            tvPasswordRequirement,
            tvPasswordRequirement2,
            TextColorModifier()
        )

        ivShield.imageTintList = valueOf(
            getColor(this, R.color.color_error)
        )
    }
    fun mediumStatus() {
        tvStrengthValue.text = "Medium"
        WarningUIAlert().tvAlert(
            this,
            tvStrengthValue,
            tvPasswordRequirement,
            tvPasswordRequirement2,
            TextColorModifier()
        )
        ivShield.imageTintList = valueOf(
            getColor(this, R.color.color_warning)
        )
    }
    fun strongStatus() {
        // Strong
        tvStrengthValue.text = "Strong"
        SuccessUIAlert().tvAlert(
            this,
            tvStrengthValue,
            tvPasswordRequirement,
            tvPasswordRequirement2,
            TextColorModifier()
        )

        ivShield.imageTintList = valueOf(
            getColor(this, R.color.color_success)
        )
    }
    fun updateStrengthUI(score: Int) {
        tvStrengthValue.post {
            when {
                score <= 1 -> weakStatus()
                score <= 3 -> mediumStatus()
                else -> strongStatus()
            }
        }
    }
    fun updatePasswordUI(textInputEditText: TextInputEditText, textView: TextView) {
        textInputEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(
                s: CharSequence?,
                start: Int,
                count: Int,
                after: Int
            ) {
            }

            override fun afterTextChanged(s: Editable?) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                updatePasswordStrength(
                    s.toString(),
                    textView
                )
            }
        })
    }
}