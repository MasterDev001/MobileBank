

import android.util.Log
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation

class LastDateTransFormation : VisualTransformation {

    // XX/XX format
    override fun filter(text: AnnotatedString): TransformedText {
        var out = ""
        text.text.forEachIndexed { index, char ->
            when (index) {
                2 -> {
                    if (out.toInt() <= 12) out += "/$char"
                    else out = "0" + out.first() + "/${out.last()}$char"
                }
                else -> out += char
            }
        }
        val numberOffsetTranslator = object : OffsetMapping {
            override fun originalToTransformed(offset: Int): Int {
                if (offset <= 2) return offset
                if (offset <= 4) return offset + 1
                return offset + 2
            }

            override fun transformedToOriginal(offset: Int): Int {
                if (offset <= 2) return offset
                if (offset <= 5) return offset - 1
                return offset - 2
            }
        }

        return TransformedText(AnnotatedString(out), numberOffsetTranslator)
    }
}