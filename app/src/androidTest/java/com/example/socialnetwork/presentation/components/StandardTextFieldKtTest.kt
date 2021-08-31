package com.example.socialnetwork.presentation.components

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performTextClearance
import androidx.compose.ui.test.performTextInput
import androidx.compose.ui.text.input.KeyboardType
import com.example.socialnetwork.MainActivity
import com.plcoding.socialnetworktwitch.presentation.util.TestTags.PASSWORD_TOGGLE
import com.plcoding.socialnetworktwitch.presentation.util.TestTags.STANDARD_TEXT_FIELD
import org.junit.Rule
import org.junit.Test

class StandardTextFieldKtTest{


    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun enterTooLongString_maxLengthNotExceeded() {
        composeTestRule.setContent {
            var text by remember {
                mutableStateOf("")
            }
            MaterialTheme {
                StandardTextField(
                    text = text,
                    onValueChange = {
                        text = it
                    },
                    maxLength = 5
                )
            }
        }

        val expectedString = "aaaaa"
        composeTestRule
            .onNodeWithTag(STANDARD_TEXT_FIELD)
            .performTextClearance()
        composeTestRule
            .onNodeWithTag(STANDARD_TEXT_FIELD)
            .performTextInput(expectedString)
        composeTestRule
            .onNodeWithTag(STANDARD_TEXT_FIELD)
            .performTextInput("a")

        composeTestRule
            .onNodeWithTag(STANDARD_TEXT_FIELD)
            .assertTextEquals(expectedString)
    }

    @Test
    fun enterPassword_toggleVisibility_passwordVisible() {
        composeTestRule.setContent {
            var text by remember {
                mutableStateOf("")
            }
            MaterialTheme {
                StandardTextField(
                    text = text,
                    onValueChange = {
                        text = it
                    },
                    maxLength = 5,
                    keyboardType = KeyboardType.Password
                )
            }
        }
        composeTestRule
            .onNodeWithTag(STANDARD_TEXT_FIELD)
            .performTextInput("aaaaa")

        composeTestRule
            .onNodeWithTag(PASSWORD_TOGGLE)
    }


}