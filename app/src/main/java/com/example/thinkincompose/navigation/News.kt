package com.example.thinkincompose.navigation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.thinkincompose.R


@Composable
fun NewsBreeze() {

// Inside this scope, whatever you put gets arranged in a vertical manner
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        // Inside this scope, whatever you put gets arranged in a horizontal manner
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
        ) {
            Image(painter = painterResource(id = R.drawable.logo2x), contentDescription = null)
        }


    }

    // this
    Row {

    }
}


@Preview(showBackground = true)
@Composable
fun NewsBreezePreview() {
    NewsBreeze()
}