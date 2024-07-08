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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
    /*
     Scaffold is a composable function that simplifies many tasks that used to
     be complex. Previously, if you wanted to show a BottomNavigationBar, TopBar,
     or FloatingActionButton, you had to manually handle their alignment.

     With Scaffold, this process becomes much easier. It introduces parameters
     like topBar, bottomBar, and floatingActionButton, where you can pass your composable
     content,and it will automatically handle the placement for you.
 */
    Scaffold(
        topBar = {
            TopAppBar(
                modifier = Modifier,
                title = {
                    // Items placed inside this Row are aligned horizontally
                    Row {
                        // Use Spacer to create space between components
                        Spacer(modifier = Modifier.size(24.dp))
                        Image(
                            painter = painterResource(id = R.drawable.logo2x),
                            contentDescription = ""
                        )
                    }
                }
            )
        }
        /*
         To align your other content below the TopAppBar, we pass the padding
         to our main composable
        */
    ) { innerPadding ->
        HomeContent(
            modifier = Modifier.padding(innerPadding),
            onClick = {
                goToDetailScreen.invoke(it)
            }
        )
    }
}

/*
Fun fact :-
In Compose, we don't have margin parameters like in traditional layouts.
We use padding to achieve a similar effect. Adding horizontal padding before specifying
width makes it act like a margin, while adding it after width makes it act as padding.
*/

@Composable
fun HomeContent(
    modifier: Modifier,
    onClick: (newsId: String) -> Unit
) {
// Items placed inside this Column are aligned horizontally
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(start = 24.dp, end = 24.dp, bottom = 24.dp)
    ) {
        // Mock data used to display the list
        val newsList = mockData()
        // LazyColumn functions similarly to RecyclerView, loading only the items that are
        // visible on the screen
        LazyColumn(
            content = {
                itemsIndexed(
                    items = newsList,
                    key = { _, item ->
                        item.id
                    }
                ) { index, it ->
                    val lastItem = index == newsList.size
                    /*
                    This composable defines the appearance of individual items in the list, passing
                    data for each item, an onClick callback, and whether it is the
                    last item
                    */
                    NewsItem(it, lastItem, onClick)
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
        Box(
            modifier = Modifier
                .background(color = Color(0xFFE8E8F7))
                .height(2.dp)
                .fillMaxWidth()
                .padding(start = 24.dp, end = 24.dp, top = 8.dp)
        )
// Using Coil library to load an image from a URL into our composable
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
// This composable displays static text on the screen
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
    HomeScreen(goToDetailScreen = {})
}