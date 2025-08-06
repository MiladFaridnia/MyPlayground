package com.faridnia.myapplication.edit_text_flow

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.callbackFlow

fun EditText.flow() = callbackFlow {

    val watcher = object : TextWatcher {
        override fun beforeTextChanged(
            s: CharSequence?,
            start: Int,
            count: Int,
            after: Int
        ) {
        }

        override fun onTextChanged(
            s: CharSequence?,
            start: Int,
            before: Int,
            count: Int
        ) {
            trySend(s.toString())
        }

        override fun afterTextChanged(s: Editable?) {

        }

    }

    addTextChangedListener(watcher)
    awaitClose { removeTextChangedListener(watcher) }

}

/*
class MyFragment : Fragment() {
    @OptIn(FlowPreview::class)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewLifecycleOwner.lifecycleScope.launch {
            view.findViewById<EditText>(R.id.editText).flow()
                .debounce(300)
                .collect { println("Input: $it") }
        }
    }
}
*/



