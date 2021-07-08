package com.io.testprojectforinstat.ui.bottom_frag

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.MediaController
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.io.testprojectforinstat.R
import kotlinx.android.synthetic.main.fragment_video_bottom.*


class VideoBottomFragment : BottomSheetDialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_video_bottom, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val mediaController = MediaController(requireContext())
        mediaController.setAnchorView(videoView)

        videoView.setMediaController(mediaController)
        videoView.setVideoURI(Uri.parse(arguments?.getString("url")))
        videoView.requestFocus()
        videoView.start()

    }

}