package com.example.lab1


import android.os.Message
import androidx.compose.foundation.Image // <-- 1. Import Composable Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape // <-- Import CircleShape để bo tròn ảnh
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip // <-- Import clip để cắt ảnh
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale // <-- Import để chỉnh cách ảnh hiển thị
import androidx.compose.ui.res.painterResource // <-- 2. Import painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.app.NotificationCompat

@Composable
fun tuan3_lab2off() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,//ngang
        verticalArrangement = Arrangement.Center // Căn giữa cho đẹp hơn
    ) {


        // --- THÊM HÌNH ẢNH TẠI ĐÂY ---
        Image(
            painter = painterResource(id = R.drawable.avatar),
            contentDescription = "Ảnh đại diện"

        )

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "I'm",
        )
        Text(
            text = "Nguyễn Hoàng Gia Thịnh",
            style = MaterialTheme.typography.headlineSmall,
        )
        Spacer(modifier = Modifier.height(48.dp))

        Button(
            onClick = {
            },
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .fillMaxWidth() // Dùng fillMaxWidth cho cân đối
                .padding(horizontal = 48.dp)
                .height(50.dp)
        ) {
            Text("I'm ")
        }
    }
}
