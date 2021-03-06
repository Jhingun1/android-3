package com.gymandroid.ui.exercise

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.gymandroid.R
import com.gymandroid.ui.exercise.dummy.DummyContent
import kotlinx.android.synthetic.main.activity_excercise_detail.*
import kotlinx.android.synthetic.main.excercise_detail.view.*

/**
 * A fragment representing a single excercise detail screen.
 * This fragment is either contained in a [excerciseListActivity]
 * in two-pane mode (on tablets) or a [excerciseDetailActivity]
 * on handsets.
 */
class excerciseDetailFragment : Fragment() {

    /**
     * The dummy content this fragment is presenting.
     */
    private var item: DummyContent.DummyItem? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            if (it.containsKey(ARG_ITEM_ID)) {
                // Load the dummy content specified by the fragment
                // arguments. In a real-world scenario, use a Loader
                // to load content from a content provider.
                item = DummyContent.ITEM_MAP[it.getString(ARG_ITEM_ID)]
//                activity?.toolbar_layout?.title = item?.content
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.excercise_detail, container, false)
//        val rootView2 = inflater.inflate(R.layout.excercise_caution, container, false)

        // Show the dummy content as text in a TextView.
        item?.let {
            rootView.excercise_detail.text = null
//            rootView2.excercise_caution.text = item?.caution
        }

        return rootView
    }

    companion object {
        /**
         * The fragment argument representing the item ID that this fragment
         * represents.
         */
        const val ARG_ITEM_ID = "item_id"
    }
}
