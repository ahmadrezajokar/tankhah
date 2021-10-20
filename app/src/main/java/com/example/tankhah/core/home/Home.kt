package com.example.tankhah.core.home

import android.util.Log
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ernestoyaquello.dragdropswiperecyclerview.listener.OnItemDragListener
import com.ernestoyaquello.dragdropswiperecyclerview.listener.OnItemSwipeListener
import com.ernestoyaquello.dragdropswiperecyclerview.listener.OnListScrollListener
import com.example.tankhah.R
import com.example.tankhah.core.dialog.dialogfokh
import com.example.tankhah.core.rvm.viewmodelfokh
import com.example.tankhah.core.tan.adapter
import com.example.tankhah.core.tan.model
import com.example.tankhah.databinding.FragmentHomeBinding
import ir.duck.hooshro.setting.BaseFragment


class Home (fm:FragmentManager) : BaseFragment<FragmentHomeBinding>(R.layout.fragment_home) {

    private var fm = fm
    private var viewmodel = context?.let { viewmodelfokh(it.applicationContext) }
    override fun onViewCreated() {


        binding.fab.setOnClickListener { view ->
            var dialogfokh: dialogfokh = dialogfokh(context?.applicationContext!!,"تنخواه")
            dialogfokh.show(fm,"namehome")
        }
        var recyclerView: RecyclerView
        recyclerView = binding.recycleviewHome

        var linearLayoutManager: LinearLayoutManager

        linearLayoutManager = LinearLayoutManager(context)

        recyclerView.layoutManager = linearLayoutManager

//
//        recyclerView.orientation = DragDropSwipeRecyclerView.ListOrientation.VERTICAL_LIST_WITH_VERTICAL_DRAGGING

//        recyclerView.behindSwipedItemIconDrawableId = R.drawable.ic_baseline_delete_24
//        recyclerView.behindSwipedItemIconSecondaryDrawableId = R.drawable.ic_baseline_check_24
//        recyclerView.itemAnimator
//        recyclerView.disableSwipeDirection(DragDropSwipeRecyclerView.ListOrientation.DirectionFlag.RIGHT)
//

//        recyclerView.isDuplicateParentStateEnabled = true

        val onItemSwipeListener = object : OnItemSwipeListener<model> {
            override fun onItemSwiped(position: Int, direction: OnItemSwipeListener.SwipeDirection, item: model): Boolean {
                // Handle action of item swiped
                // Return false to indicate that the swiped item should be removed from the adapter's data set (default behaviour)
                // Return true to stop the swiped item from being automatically removed from the adapter's data set (in this case, it will be your responsibility to manually update the data set as necessary)

                with(direction){
                    OnItemSwipeListener.SwipeDirection.LEFT_TO_RIGHT
                    {
                        Log.e("ahmadreza", "onItemSwiped:  ${item.id}" )

                    }
                }
                return false
            }
        }
        recyclerView.swipeListener = onItemSwipeListener

        val onItemDragListener = object : OnItemDragListener<model> {
            override fun onItemDragged(previousPosition: Int, newPosition: Int, item: model) {
                Log.e("ahmadreza", "onItemDragged: ${item.id} ")
            }

            override fun onItemDropped(initialPosition: Int, finalPosition: Int, item: model) {
//                var model = item
//                viewmodel?.deleteHome(model)
                Log.e("ahmadreza", "onItemDropped: ${item.id}" )
            }
        }

        recyclerView.dragListener = onItemDragListener

        val onListScrollListener = object : OnListScrollListener {
            override fun onListScrollStateChanged(scrollState: OnListScrollListener.ScrollState) {
                // Handle change on list scroll state
                Log.e("ahmadreza", "onListScrollStateChanged: " )
            }

            override fun onListScrolled(scrollDirection: OnListScrollListener.ScrollDirection, distance: Int) {
                // Handle scrolling
                Log.e("ahmadreza", "onListScrolled: " )
            }
        }
        recyclerView.scrollListener = onListScrollListener




        viewmodel?.gethome()?.observe(viewLifecycleOwner, androidx.lifecycle.Observer { list->
            var adapter = context?.let { adapter(it, list,fm) }
            recyclerView.adapter = adapter

        })




    }






}