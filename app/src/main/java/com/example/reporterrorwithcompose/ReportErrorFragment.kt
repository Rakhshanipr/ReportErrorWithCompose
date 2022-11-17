package com.example.reporterrorwithcompose

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.fragment.app.Fragment
import com.example.reporterrorwithcompose.databinding.FragmentReportErrorBinding


class ReportErrorFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
        }
    }

    lateinit var binding: FragmentReportErrorBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentReportErrorBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.composeView.setContent {
            allContent()
        }
    }

    @Composable
    fun allContent(modifier: Modifier = Modifier) {
        Column(modifier.background(Color(0xFFF5F5F5))) {
            TextViewHelper(modifier)
            EnterReport(modifier)
            Spacer(modifier.weight(1f))
            sendBtn()
        }
    }

    @Composable
    fun TextViewHelper(modifier: Modifier = Modifier) {
        Surface(
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .padding(top = 24.dp)

        ) {
            Text(
                modifier = modifier.background(Color(0xFFF5F5F5)),
                text = requireActivity().getString(R.string.pfm_report_error_description),
                style = TextStyle(
                    color = Color(0xFF7075A0),
                    fontFamily = FontFamily.Serif,
                    fontSize = 18.sp,
                    textAlign = TextAlign.Start
                )
            )
        }
    }

    @Composable
    fun EnterReport(modifier: Modifier = Modifier) {
        Surface(modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .padding(top = 16.dp)
            .height(150.dp)
            .shadow(15.dp, shape = RoundedCornerShape(8.dp))
            .padding(top = 4.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(Color.White)) {
            Column(

            ) {
                Text(
                    text = "گزارش خطا", style = TextStyle(
                        fontSize = 18.sp,
                        color = Color.Black,
                        fontFamily = FontFamily.SansSerif
                    ),
                    modifier = modifier
                        .padding(start = 16.dp)
                        .padding(top = 8.dp)
                )

                var text by remember {
                    mutableStateOf("")
                }

                TextField(
                    colors = TextFieldDefaults.textFieldColors(
                        backgroundColor = Color.White,
                        cursorColor = Color.Black,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent
                    ),
                    textStyle = TextStyle.Default.copy(
                        fontSize = 18.sp,
                        fontFamily = FontFamily.SansSerif
                    ),
                    modifier = modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .padding(top = 0.dp)
                        .padding(bottom = 8.dp)
                        .padding(start = 0.dp),
                    placeholder = {
                        PlaceHolderText(modifier)
                    },
                    value = text,
                    onValueChange = { value: String -> text = value })

            }
        }
    }

    @Composable
    fun PlaceHolderText(modifier: Modifier = Modifier) {
        Text(
            text = "وارد کردن متن گزارش", style = TextStyle(
                color = Color(0xFFB8BBD9), fontSize = 18.sp, fontFamily = FontFamily.SansSerif
            )
        )
    }

    @Composable
    fun sendBtn(modifier: Modifier =Modifier){
        Surface(modifier = modifier
            .fillMaxWidth()
            .height(52.dp)) {
            Button(
                onClick ={},
                colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF2E8EEE))
            ){
                Text(text = "گزارش خطا", style = TextStyle(
                    fontSize = 20.sp,
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    fontFamily = FontFamily.SansSerif
                ))
            }

        }

    }
    
    companion object {

        @JvmStatic
        fun newInstance() =
            ReportErrorFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}