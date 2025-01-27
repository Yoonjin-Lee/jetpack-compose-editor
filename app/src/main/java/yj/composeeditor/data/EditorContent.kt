package yj.composeeditor.data

sealed class EditorContent {
    data class TextContent (val text: String) : EditorContent()
    data class ImageContent (val imageUrl: String) : EditorContent()
}