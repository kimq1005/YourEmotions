package com.example.YourEmotions.fragment3

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.YourEmotions.R
import com.example.YourEmotions.databinding.Fragment3Binding
import kotlinx.android.synthetic.main.fragment_3.*


class Fragment3 : Fragment(R.layout.fragment_3) {
    private lateinit var fragment3Adapter: Fragment3Adapter
    private var binding:Fragment3Binding? =null

    companion object{
        fun newInstance() : Fragment3 {
            return Fragment3()
        }
    }

    //프래그먼트를 안고 있는 엑티비티에 붙었을때
    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?,
//    ): View? {
//
//
//        return inflater.inflate(R.layout.fragment_3, container, false)
//    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val fragment3Binding = Fragment3Binding.bind(view)
        binding = fragment3Binding

        fragment3RecyclerView.apply{
            fragment3Adapter= Fragment3Adapter()
            adapter = fragment3Adapter
            layoutManager=LinearLayoutManager(context)
        }



    }


}