package com.yusuf0080.komdigiapps.ui.screen

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.yusuf0080.komdigiapps.R
import com.yusuf0080.komdigiapps.ui.theme.KomdigiAppsTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen() {
    var judul by remember { mutableStateOf("") }
    var catatan by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = stringResource(id = R.string.tambah_catatan))
                },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                )
            )
        }
    ) { padding ->
        FormCatatan(
            title = judul,
            onTitleChange = { judul = it },
            desc = catatan,
            onDescChange = { catatan = it },
            modifier = Modifier.padding(padding)
        )
    }
}

@Composable
fun FormCatatan(
    title: String, onTitleChange: (String) -> Unit,
    desc: String, onDescChange: (String) -> Unit,
    modifier: Modifier
) {
    Column(
        modifier = modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        OutlinedTextField(
            value = title,
            onValueChange = { onTitleChange(it) },
            label = { Text(text = stringResource(R.string.judul)) },
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                capitalization = KeyboardCapitalization.Words,
                imeAction = ImeAction.Next
            ),
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = desc,
            onValueChange = { onDescChange(it) },
            label = { Text(text = stringResource(R.string.isi_catatan)) },
            keyboardOptions = KeyboardOptions(
                capitalization = KeyboardCapitalization.Sentences
            ),
            modifier = Modifier.fillMaxSize()
        )
    }
}

@Preview(showBackground = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun DetailScreenPreview() {
    KomdigiAppsTheme {
        DetailScreen()
    }
}