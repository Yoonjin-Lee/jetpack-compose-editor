package yj.composeeditor

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import yj.composeeditor.data.EditorContent
import yj.composeeditor.ui.theme.ComposeEditorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MainScreen()
        }
    }
}

@Composable
fun MainScreen(){
    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) {
        // 글, 사진 portion
        Box(modifier = Modifier.padding(it)){
            Editor()
        }


    }
}

// Editor UI
@Composable
fun Editor() {
    // 리스트에 EditorContent 저장
    var contentList by remember { mutableStateOf(listOf<EditorContent>()) }

    // 화면에 보여줘야 함
    Column {
        contentList.forEach { content ->
            when (content) {
                is EditorContent.TextContent -> {
                    Text(
                        text = content.text,
                        modifier = Modifier.padding(16.dp)
                    )
                }
                is EditorContent.ImageContent -> {
                    AsyncImage(content.imageUrl, null)
                }
            }
        }
    }
}

@Preview
@Composable
fun EditorPreview() {
    ComposeEditorTheme {

    }
}