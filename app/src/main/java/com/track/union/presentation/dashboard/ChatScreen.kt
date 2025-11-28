package com.track.union.presentation.dashboard

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.track.union.R
import com.track.union.presentation.auth.CommonTopBar
import com.track.union.utils.SpacerHeight
import com.track.union.utils.SpacerWidth


data class ChatMessage(
    val text: String,
    val isUser: Boolean
)

@Composable
fun SenderBubble(message: ChatMessage) {
    Column(horizontalAlignment = Alignment.End) {


        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {
            Box(
                modifier = Modifier
                    .background(
                        colorResource(R.color.def_pick_notes_bg_color),
                        RoundedCornerShape(topStart = 10.dp, bottomStart = 10.dp, bottomEnd = 10.dp)
                    )
                    .border(
                        width = 1.dp,
                        color = colorResource(R.color.primary_color),
                        shape = RoundedCornerShape(
                            topStart = 10.dp,
                            bottomStart = 10.dp,
                            bottomEnd = 10.dp
                        )
                    )
                    .padding(12.dp)
            ) {
                Text(
                    text = message.text,
                    color = colorResource(R.color.card_text_color),
                    fontFamily = FontFamily(Font(R.font.poppins_regular))
                )
            }
        }
        SpacerHeight(3.dp)
        Text(
            text ="just now",
            color = colorResource(R.color.card_text_color),
            fontFamily = FontFamily(Font(R.font.poppins_regular)), fontSize = 12.sp
        )
    }
}

@Composable
fun ReceiverBubble(message: ChatMessage) {
    Column (horizontalAlignment = Alignment.End) {
        Row(
            modifier = Modifier,
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(R.drawable.chat_image),
                contentDescription = null,
                modifier = Modifier.size(30.dp).clip(CircleShape)
            )
            SpacerWidth(8.dp)
            Box(
                modifier = Modifier
                    .background(
                        colorResource(R.color.def_pick_notes_bg_color),
                        RoundedCornerShape(topEnd = 10.dp, bottomStart = 10.dp, bottomEnd = 10.dp)
                    )
                    .padding(12.dp)
            ) {
                Row(modifier = Modifier) {


                    Text(
                        text = message.text,
                        color = colorResource(R.color.card_text_color),
                        fontFamily = FontFamily(Font(R.font.poppins_regular)),
                        fontSize = 14.sp
                    )
                }

            }
        }
        SpacerHeight(3.dp)
        Text(
            text = "8:29 pm",
            color = colorResource(R.color.card_text_color),
            fontFamily = FontFamily(Font(R.font.poppins_regular)), fontSize = 12.sp
        )
    }
}

@Composable
fun ChatScreen(navController: NavController
               ,modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(R.color.def_bg_color))
            .padding(horizontal = 22.dp, vertical = 44.dp)
    ) {
        CommonTopBar(
            title = "Chat",
            onBackClick = {}
        )
        SpacerHeight(30.dp)
//        val messages = remember { mutableStateListOf<ChatMessage>() }
        val messages = remember {
            mutableStateListOf(
                ChatMessage("Good Evening!!", isUser = false),
                ChatMessage("Where are you", isUser = false),
                ChatMessage("I am in Nakawa", isUser = true),

            )
        }
        LazyColumn(
            modifier = Modifier
                .weight(1f),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            reverseLayout = false
        ) {
            items(messages) { msg ->
                if (msg.isUser) SenderBubble(msg) else ReceiverBubble(msg)
            }
        }
        var text by remember { mutableStateOf("") }

        OutlinedTextField(
            value = text,
            onValueChange = { text = it },
            placeholder = {
                Text(
                    "Type your message",
                    color = colorResource(R.color.hint_color),
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_regular))
                )
            },
            modifier = Modifier
                .fillMaxWidth(),
            shape = RoundedCornerShape(10.dp),
            textStyle = TextStyle(Color.Black),
            trailingIcon = {
                Image(
                    painter = painterResource(R.drawable.send_icon),
                    contentDescription = null,
                    modifier = Modifier
                        .size(22.dp)
                        .clickable {
                        }
                )
            },
            colors = OutlinedTextFieldDefaults.colors(
                cursorColor = colorResource(R.color.hint_color),
                unfocusedBorderColor = colorResource(R.color.hint_color),
                focusedBorderColor = colorResource(R.color.primary_color)
            )
        )
        Spacer(modifier = Modifier.height(30.dp))
    }
}

@Preview(showSystemUi = true)
@Composable
fun ChatScreenPrev(modifier: Modifier = Modifier) {
    val messages = remember {
        mutableStateListOf(
            ChatMessage("Hello!", isUser = false),
            ChatMessage("Hi, how are you?", isUser = true),
            ChatMessage("I'm good, thanks!", isUser = false),
            ChatMessage("Great to hear!", isUser = true),
            ChatMessage("What are you working on?", isUser = false),
            ChatMessage("A Jetpack Compose chat UI preview.", isUser = true)
        )
    }
    val navController= rememberNavController()
    ChatScreen(navController=navController)
}