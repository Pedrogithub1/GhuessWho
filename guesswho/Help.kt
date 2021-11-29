package mx.com.fullcomputer.guesswho

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import mx.com.fullcomputer.guesswho.databinding.ActivityHelpBinding

class Help : AppCompatActivity() {

    private lateinit var binding: ActivityHelpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHelpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnExit.setOnClickListener {
            finish()
        }
    }
}