package com.example.thinkincompose

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
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
import com.example.thinkincompose.MockData.getNewsById
import com.example.thinkincompose.ui.theme.paragraph
import com.example.thinkincompose.ui.theme.paragraphLarge
import com.example.thinkincompose.ui.theme.smallParagraph


@Composable
fun NewsDetailScreen(
    newsId: String?,
    onBack: () -> Unit
) {
    val data = getNewsById(newsId.orEmpty())
    NewsDetailContent(
        data = data,
        onBack = onBack
    )
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewsDetailContent(
    data: NewsItem?,
    onBack: () -> Unit
) {
    Box(
        modifier = Modifier
    ) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(data = data?.image.orEmpty())
                .error(R.drawable.pic)
                .placeholder(R.drawable.pic)
                .crossfade(true)
                .build(),
            contentDescription = "bankIcon",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(190.dp)
                .background(Color.Blue)
        )
        Column(
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(),
        ) {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Transparent
                ),
                navigationIcon = {
                    Row {
                        Spacer(modifier = Modifier.size(12.dp))
                        Icon(
                            modifier = Modifier
                                .size(16.dp)
                                .clickable {
                                    onBack.invoke()
                                },
                            painter = painterResource(id = R.drawable.ic_back),
                            tint = Color.White,
                            contentDescription = ""
                        )
                    }
                },
                title = {
                }
            )

            Text(
                modifier = Modifier.padding(horizontal = 24.dp),
                text = data?.time.orEmpty(),
                style = MaterialTheme.typography.smallParagraph,
                color = Color(0xFFFFFFFF),
                maxLines = 3
            )
            Spacer(modifier = Modifier.size(16.dp))
            Text(
                modifier = Modifier.padding(horizontal = 24.dp),
                text = data?.headline.orEmpty(),
                style = MaterialTheme.typography.paragraph,
                color = Color(0xFFFFFFFF),
                maxLines = 3
            )
            NewsDetail(data)
        }
    }
}

@Composable
fun NewsDetail(
    data: NewsItem?
) {
    Column(
        modifier = Modifier
            .padding(top = 24.dp)
            .fillMaxSize()
            .background(
                color = Color.White,
                shape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp)
            )
            .padding(start = 24.dp, end = 24.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 24.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(data = data?.userData?.photoUrl.orEmpty())
                    .error(R.drawable.pic)
                    .placeholder(R.drawable.pic)
                    .crossfade(true)
                    .build(),
                contentDescription = "bankIcon",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .background(Color.Blue)
            )
            Spacer(modifier = Modifier.size(8.dp))

            Column {
                Text(
                    text = data?.userData?.name.orEmpty(),
                    style = MaterialTheme.typography.paragraph,
                    color = Color(0xFF000000),
                )
                Spacer(modifier = Modifier.size(2.dp))
                Text(
                    text = data?.category.orEmpty(),
                    style = MaterialTheme.typography.paragraph,
                    color = Color.Red,
                )
            }

        }
        Spacer(modifier = Modifier.size(24.dp))
        // news description
        Text(
            text = data?.description.orEmpty(),
            style = MaterialTheme.typography.paragraphLarge,
            color = Color(0xFF000000),
        )
    }
}

@Preview(showBackground = true)
@Composable
fun NewsDetailPreview() {
    // Calling our composable function to preview its UI
    val data = getNewsById("1")
    NewsDetailContent(data, {})
}