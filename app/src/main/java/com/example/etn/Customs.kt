import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.etn.R

class Customs(
    private val context: Context,
    private val texts: Array<String>
) : ArrayAdapter<String>(context, 0, texts) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        return createCustomView(position, convertView, parent)
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        return createCustomView(position, convertView, parent)
    }

    private fun createCustomView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.custom_spinner_item, parent, false)

        val textView = view.findViewById<TextView>(R.id.spinner_text)
        textView.text = texts[position]

        return view
    }
}
