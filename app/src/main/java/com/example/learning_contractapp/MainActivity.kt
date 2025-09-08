package com.example.learning_contractapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.learning_contractapp.ui.theme.Learning_ContractAPPTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Learning_ContractAPPTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    LearningContractScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun LearningContractScreen(modifier: Modifier = Modifier) {
    // Data for your Learning Contract
    // Replace these with your actual contract details
    val contractTitle = "Learning Contract"
    val expectations = "Expectations"
    val content1 = """
        - Understand the basics of Android app development.
        - Learn how to create UIs with Jetpack Compose.
        - Be able to build and run a simple Android application.
    """.trimIndent() // trimIndent() do for cleaner multiline strings

    val contributions = "Contributions"
    val content2 = """
        - Complete given tasks and projects.
        - Help others in some task i can help with.
        - Will try to learn the difficulties.
    """.trimIndent()

    val motivations = "Motivations"
    val content3 = """
        - Complete necessary learnings.
        - Finish my studies.
        - Fully grasp coding in mobile devices.
    """.trimIndent()

    val hindrances = "Hindrances"
    val content4 = """
        - Lack of time due to other commitments.
        - Difficulty understanding complex topics without extra resources..
        - Distractions from social media and friends .
    """.trimIndent()

    val signature = "Alfred Binay-an"

    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()) // Makes the column scrollable
            .padding(40.dp), // Add padding around the entire content
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = contractTitle,
            fontSize = 24.sp, // Larger font size for the title
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.headlineMedium // Using MaterialTheme for styling
        )
        Spacer(modifier = Modifier.height(50.dp)) // Adds vertical space

        ContractSection(title = expectations, content = content1)
        ContractSection(title = contributions, content = content2)
        ContractSection(title = motivations, content = content3)
        ContractSection(title = hindrances, content = content4)

        Spacer(modifier = Modifier.height(32.dp)) // More space before the signer

        Text(
            text = "Signed:",
            fontSize = 16.sp,
            style = MaterialTheme.typography.bodyLarge
        )
        Text(
            text = signature,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.titleMedium
        )
        Spacer(modifier = Modifier.height(16.dp)) // Space at the bottom
    }
}

@Composable
fun ContractSection(title: String, content: String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.padding(vertical = 8.dp), // Add vertical padding to each section
        horizontalAlignment = Alignment.Start // Align content to the start of the column
    ) {
        Text(
            text = title,
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold,
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(bottom = 4.dp) // Space between title and content
        )
        Text(
            text = content,
            fontSize = 16.sp,
            style = MaterialTheme.typography.bodyLarge,
            lineHeight = 20.sp // Improves readability of longer text blocks
        )
        Spacer(modifier = Modifier.height(16.dp)) // Space after each section
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LearningContractScreenPreview() {
    Learning_ContractAPPTheme {
        LearningContractScreen()
    }
}
