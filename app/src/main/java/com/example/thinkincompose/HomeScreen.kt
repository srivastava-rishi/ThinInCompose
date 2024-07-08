package com.example.thinkincompose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.thinkincompose.MockData.mockData
import com.example.thinkincompose.ui.theme.paragraph
import com.example.thinkincompose.ui.theme.smallParagraph


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    goToDetailScreen: (String) -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                modifier = Modifier,
                navigationIcon = {
                    Row {
                        Spacer(modifier = Modifier.size(24.dp))
                        Image(
                            painter = painterResource(id = R.drawable.logo2x),
                            contentDescription = ""
                        )
                    }
                },
                title = {
                }
            )
        }
    ) { innerPadding ->
        HomeContent(
            modifier = Modifier.padding(innerPadding),
            onClick = {
                goToDetailScreen.invoke(it)
            }
        )
    }
}


@Composable
fun HomeContent(
    modifier: Modifier,
    onClick: (newsId: String) -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(start = 24.dp, end = 24.dp, bottom = 24.dp)
    ) {
        val newsList = mockData()
        LazyColumn(
            content = {
                itemsIndexed(
                    items = newsList,
                    key = { _, item ->
                        item.id
                    }
                ) { index, it ->
                    val lastItem = index == newsList.size
                    NewsItem(it, lastItem,onClick)
                }
            })
    }
}


@Composable
fun NewsItem(
    item: NewsItem,
    lastItem: Boolean,
    onClick: (newsId: String) -> Unit
) {
    Column(
        modifier = Modifier
            .padding(
                top = if (!lastItem) 8.dp else 0.dp
            )
    ) {
        // upper line
        Box(
            modifier = Modifier
                .background(color = Color(0xFFE8E8F7))
                .height(2.dp)
                .fillMaxWidth()
                .padding(start = 24.dp, end = 24.dp, top = 8.dp)
        )

        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(data = item.image)
                .error(R.drawable.pic)
                .placeholder(R.drawable.pic)
                .crossfade(true)
                .build(),
            contentDescription = "bankIcon",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(top = 16.dp)
                .fillMaxWidth()
                .height(200.dp)
                .clip(RoundedCornerShape(12.dp))
                .background(Color.Blue)
        )

        Spacer(modifier = Modifier.size(16.dp))
        Text(
            text = item.headline,
            style = MaterialTheme.typography.paragraph,
            color = Color(0xFF181818),
            maxLines = 2
        )
        Spacer(modifier = Modifier.size(16.dp))
        Text(
            text = item.description,
            style = MaterialTheme.typography.smallParagraph,
            color = Color(0xFF181818),
            maxLines = 3
        )
        Spacer(modifier = Modifier.size(16.dp))

        Button(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally),
            shape = RoundedCornerShape(6.dp),
            contentPadding = PaddingValues(0.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF94C77D)
            ),
            content = {
                Text(
                    text = "Read more",
                    color = Color(0xFFFFFFFF),
                    style = MaterialTheme.typography.smallParagraph,
                    maxLines = 1
                )
            },
            onClick = {
               onClick.invoke(item.id)
            },
        )
    }
}


@Preview(showBackground = true)
@Composable
fun Preview() {
    // Calling our composable function to preview its UI
    HomeContent(modifier = Modifier,{})
}