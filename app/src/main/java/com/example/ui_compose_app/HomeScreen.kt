package com.example.ui_compose_app

import android.content.Intent
import android.net.Uri
import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Icon
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Text
import androidx.compose.material3.Card

import androidx.compose.material3.MaterialTheme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf

import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ui_compose_app.ui.theme.ButtonBlue
import com.example.ui_compose_app.ui.theme.DarkerButtonBlue
import com.example.ui_compose_app.ui.theme.DeepBlue
import com.example.ui_compose_app.ui.theme.TextWhite

@Composable

fun HomeScreen() {
    Box(
        modifier = Modifier
            .background(DeepBlue)
            .fillMaxSize()

    )

    {
        Column(
            modifier = Modifier,
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.Start

        ) {
            Greeting()
            ChipSection(chips = listOf(" Sweet Sleep", "Insomnia", "Depression"))
            Meditation()
            Features()
            BottomMenu()
        }


    }
}

@Composable
fun Greeting(
    name: String = "Amir",
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            //  .background(Color.Yellow)

            .padding(25.dp),

        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically

    ) {
        Column(
            modifier = Modifier
                .width(300.dp)
                .padding(top = 20.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Good morning, Mr $name",

                color = Color.White,
                // modifier=Modifier.background(Color.Yellow).fillMaxWidth(),
                fontSize = 20.sp
            )
            Text(
                text = "Wish you all success",
                style = androidx.compose.material.MaterialTheme.typography.body2,
                color = Color.White
            )
        }
        Icon(
            painter = painterResource(id = R.drawable.ic_search),
            contentDescription = "search here",
            tint = Color.White,
            //tint = Color.Red,

            modifier = Modifier.size(24.dp)
        )

    }

}
///

@Composable
fun ChipSection(
    chips: List<String>,
) {

    var selectedChip by remember {
        mutableIntStateOf(0)
    }
    LazyRow {
        items(chips.size) {
            Box(contentAlignment = Alignment.Center,
                modifier = Modifier
                    .padding(start = 15.dp, top = 15.dp, bottom = 15.dp)
                    .clickable {
                        selectedChip = it
                    }
                    .clip(RoundedCornerShape(10.dp))
                    .background(
                        if (selectedChip == it) ButtonBlue
                        else DarkerButtonBlue
                    )
                    .padding(15.dp)) {
                Text(text = chips[it], color = TextWhite)
            }
        }

    }

}
///

@Composable
fun Meditation(

) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            //  .background(Color.Yellow)
            .padding(25.dp),

        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically

    ) {
        Column(
            modifier = Modifier.width(200.dp), verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Meditation time ",
                // style = androidx.compose.material.MaterialTheme.typography.h5,
                fontSize = 20.sp,
                color = Color.White


            )
            Text(
                text = "time to relax",
                style = androidx.compose.material.MaterialTheme.typography.body2,
                color = Color.White
            )
        }
        Column(
            modifier = Modifier.width(200.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.End
        ) {
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .background(Color.Red)
                    .padding(10.dp)

            ) {
                //Youtube Icon Redirect.

                YouTubeRedirectIcon()

            }

            Spacer(modifier = Modifier.height(2.dp))
            val context = LocalContext.current
            Text(
                modifier = Modifier
                    .clickable {
                        val intent = Intent(
                            Intent.ACTION_VIEW,
                            Uri.parse("https://www.youtube.com/watch?v=3NycM9lYdRI&t=648s")
                        )
                        context.startActivity(intent)
                    },
                text = "Click Me",
                fontSize = 10.sp,
                color = Color.White

            )

        }


    }
}

@Composable
fun YouTubeRedirectIcon() {
    val context = LocalContext.current

    Icon(
        painter = painterResource(id = R.drawable.ic_play),
        contentDescription = "Play",
        tint = Color.White,
        modifier = Modifier
            .size(24.dp)
            .clickable {
                val intent = Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://www.youtube.com/watch?v=3NycM9lYdRI&t=648s")
                )
                context.startActivity(intent)
            }
    )


}

@Composable

fun Features() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
        //  .background(Color.Green)
    ) {
        Text(
            text = "Features",
            style = androidx.compose.material.MaterialTheme.typography.h5,
            color = Color.White,
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
                .padding(start = 12.dp)
        )
        Image_Card()


    }

}

val randomSizedPhotos = listOf(
    R.drawable.img1,
    R.drawable.img2,
    R.drawable.img3,
    R.drawable.img4,

    )

@Composable
fun Image_Card() {
    Box(
        modifier = Modifier
            //     .background(Color.Red)
            .height(390.dp)
    ) {
        LazyVerticalStaggeredGrid(
            columns = StaggeredGridCells.Fixed(2),
            verticalItemSpacing = 2.dp,
            horizontalArrangement = Arrangement.spacedBy(2.dp),
            content = {
                items(randomSizedPhotos) { photo ->
                    ImageCard(imageRes = photo)
                }
            },
            //modifier = Modifier.width(400.dp).background(Color.Black)
        )


    }
}


@Composable
fun ImageCard(imageRes: Int) {
    Card(
        modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth()
            .height(200.dp)

    ) {
        AsyncImage(
            resourceId = imageRes,
            contentScale = ContentScale.Crop,
            contentDescription = "images",

            modifier = Modifier
                .fillMaxWidth()
//                .wrapContentHeight()
        )
    }
}

@Composable
fun AsyncImage(
    @DrawableRes resourceId: Int,
    contentScale: ContentScale,
    contentDescription: String?,
    modifier: Modifier,
) {
    // Load image using resourceId
    Box(
        modifier = modifier.background(Color.Cyan)
    ) {
        // Load image using painterResource and resourceId
        androidx.compose.foundation.Image(
            painter = painterResource(id = resourceId),
            contentDescription = contentDescription,
            contentScale = contentScale,
            modifier = Modifier.width(200.dp)
        )
    }
}

@Composable
fun BottomMenu() {
    var selectedItem by remember { mutableIntStateOf(0) }
    val items = listOf(
        MenuItem("Home", R.drawable.ic_home),
        MenuItem("Search", R.drawable.ic_search),
        MenuItem("Profile", R.drawable.ic_profile),
        MenuItem("Sleep", R.drawable.ic_moon),
        MenuItem("Music", R.drawable.ic_music)
    )

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        //Box(modifier = Modifier.weight(1f))
        Row(
            modifier = Modifier
                .fillMaxWidth()
            // .background(Color.Red)
            ,
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            items.forEachIndexed { index, item ->
                BottomMenuItem(
                    item = item,
                    isSelected = selectedItem == index,
                    onClick = { selectedItem = index }
                )
            }
        }
    }
}

@Composable
fun BottomMenuItem(item: MenuItem, isSelected: Boolean, onClick: () -> Unit) {
    Column(
        modifier = Modifier
            .clickable(onClick = onClick)
            .padding(8.dp)
        //.clip(RoundedCornerShape(2.dp))
        // .background(if (isSelected) Color(0xFFE0F7FA) else Color.Transparent) // Light cyan for selected background
        ,

        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            painter = painterResource(id = item.iconRes),
            contentDescription = item.label,
            tint = if (isSelected) MaterialTheme.colorScheme.tertiary else Color.LightGray,
            modifier = Modifier.size(20.dp)
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = item.label,
            color = if (isSelected) MaterialTheme.colorScheme.primary else Color.Gray,
            fontSize = 12.sp,
            fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal
        )
    }
}

