package com.example.androidsandbox

import android.graphics.Typeface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.navigation.fragment.findNavController
import com.example.androidsandbox.databinding.FragmentBlankBinding
import com.example.androidsandbox.fragment.CommonDialogFragment
import com.example.androidsandbox.fragment.CommonDialogFragmentBuilder
import it.sephiroth.android.library.xtooltip.ClosePolicy
import it.sephiroth.android.library.xtooltip.Tooltip

/**
 * A simple [Fragment] subclass.
 * Use the [BlankFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class BlankFragment : Fragment() {
    private var _binding: FragmentBlankBinding? = null
    private val binding get() = _binding!!

    private var toolTip: Tooltip? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)

        _binding = FragmentBlankBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.button.setOnClickListener {
            findNavController().navigate(R.id.action_blankFragment_to_mainFragment)
        }

        binding.alertButton1.setOnClickListener {
            AlertDialog.Builder(requireActivity())
                    .setTitle("アラート1")
                    .setMessage("AlertDialogBuilderから作ったやつ")
                    .setPositiveButton("OK") { _, _ ->
                        Toast.makeText(requireActivity(), "OKボタン", Toast.LENGTH_SHORT).show()
                    }
                    .setNegativeButton("CANCEL") { _, _ ->
                        Toast.makeText(requireActivity(), "CANCELボタン", Toast.LENGTH_SHORT).show()
                    }
                    .show()
        }

        binding.alertButton2.setOnClickListener {
            val callback = object : CommonDialogFragment.Companion.Callback {
                override fun onClickPositiveButton() {
                    Toast.makeText(requireActivity(), "OKボタン", Toast.LENGTH_SHORT).show()
                }

                override fun onClickNegativeButton() {
                    Toast.makeText(requireActivity(), "CANCELボタン", Toast.LENGTH_SHORT).show()
                }
            }
            CommonDialogFragment.show(requireActivity().supportFragmentManager,
            "アラート2", "Callbackを保持したDialog", "OK", "CANCEL", callback)
        }

        binding.alertButton3.setOnClickListener {
            CommonDialogFragmentBuilder(requireActivity())
                    .setTitle("アラート1")
                    .setMessage("AlertDialogBuilderから作ったやつ")
                    .setPositiveButton("OK") { _, _ ->
                        Toast.makeText(requireActivity(), "OKボタン", Toast.LENGTH_SHORT).show()
                    }
                    .setNegativeButton("CANCEL") { _, _ ->
                        Toast.makeText(requireActivity(), "CANCELボタン", Toast.LENGTH_SHORT).show()
                    }
                    .show()
        }

//        binding.root.post { showToolTip() }
    }

    private fun showToolTip() {
        toolTip = Tooltip.Builder(requireContext())
            .anchor(binding.button, 0, 0, true)
            .text("tooltip")
            .typeface(Typeface.DEFAULT_BOLD)
            .arrow(true)
            .floatingAnimation(Tooltip.Animation.DEFAULT)
            .closePolicy(ClosePolicy.TOUCH_ANYWHERE_CONSUME)
            .overlay(false)
            .create()

        toolTip
            ?.doOnShown { Toast.makeText(requireContext(), "show tool tip", Toast.LENGTH_SHORT).show() }
            ?.doOnHidden {
                binding.button.callOnClick()
                Toast.makeText(requireContext(), "hidden tool tip", Toast.LENGTH_SHORT).show()
            }
            ?.show(binding.button, Tooltip.Gravity.BOTTOM, true)
    }
}