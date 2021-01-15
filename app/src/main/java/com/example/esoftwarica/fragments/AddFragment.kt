package com.example.esoftwarica.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import com.example.esoftwarica.R
import com.example.esoftwarica.StudentData
import com.example.esoftwarica.model.Students

class AddFragment : Fragment() {
    private lateinit var etfullname: EditText
    private lateinit var etage: EditText
    private lateinit var etaddress: EditText
    private lateinit var etrad:RadioGroup
    private lateinit var etradmale: RadioButton
    private lateinit var etradfemale: RadioButton
    private lateinit var etradothers: RadioButton
    private lateinit var btnsave: Button
    private lateinit var etimage:EditText


    var newStudent= ArrayList<Students>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_add, container, false)

        etfullname = view.findViewById(R.id.etfullname)
        etage = view.findViewById(R.id.etage)
        etaddress = view.findViewById(R.id.etaddress)
        etrad = view.findViewById(R.id.etrad)
        etradmale=view.findViewById(R.id.etradmale)
        etradfemale=view.findViewById(R.id.etradfemale)
        etradothers=view.findViewById(R.id.etradothers)
        btnsave = view.findViewById(R.id.btnsave)
        etimage=view.findViewById(R.id.etimage)

        btnsave.setOnClickListener {

            var name = etfullname.text.toString();
            var age = etage.text.toString().toInt();
            var address = etaddress.text.toString();
            var gender = etrad.checkedRadioButtonId.toString();
            var eimage = etimage.text.toString();

            if (etrad.checkedRadioButtonId != 1) {
                if (etradmale.isChecked) {
                    gender = "male"
                } else if (etradfemale.isChecked) {
                    gender = "female"
                } else if (etradothers.isChecked) {
                    gender = "others"
                }
            }


            var studentdata=Students(id,name,age,address,gender,eimage)

            newStudent.add(studentdata);
            var bundle = Bundle()
            bundle.putString("data", "yourdata");
            var homeFragment = HomeFragment();
            homeFragment.arguments = bundle
            StudentData.get().List().add(studentdata);

            etfullname.setText("")
            etage.setText("")
            etradmale.isChecked = false
            etradfemale.isChecked = false
            etradothers.isChecked = false
            etaddress.setText("")
            etimage.setText("")

        }
        return view
    }
    }




