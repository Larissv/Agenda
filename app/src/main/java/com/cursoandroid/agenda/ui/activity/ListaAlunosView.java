package com.cursoandroid.agenda.ui.activity;

import android.app.AlertDialog;
import android.content.Context;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;

import com.cursoandroid.agenda.DAO.AlunoDAO;
import com.cursoandroid.agenda.model.Aluno;
import com.cursoandroid.agenda.ui.activity.adapter.ListaAlunosAdapter;

public class ListaAlunosView {

    private ListaAlunosAdapter adapter;
    private final AlunoDAO dao;
    private final Context context;

    public ListaAlunosView(Context context) {
        this.context = context;
        this.adapter = new ListaAlunosAdapter(this.context);
        this.dao = new AlunoDAO();
    }

    public void confirmaRemocao(MenuItem item) {
        new AlertDialog.Builder(context)
                .setTitle("Removendo aluno")
                .setMessage("Tem certeza que quer remover o aluno?")
                .setPositiveButton("Sim", (dialogInterface, i) -> {
                    AdapterView.AdapterContextMenuInfo menuInfo =
                            (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
                    Aluno alunoEscolhido = adapter.getItem(menuInfo.position);
                    remove(alunoEscolhido);
                })
                .setNegativeButton("Nao", null)
                .show();
    }

    public void atualizaAlunos() {
        adapter.atualiza(dao.todos());
    }

    public void remove(Aluno alunoEscolhido) {
        dao.remove(alunoEscolhido);
        adapter.remove(alunoEscolhido);
    }

    public void configuraAdapter(ListView listaDeAlunos) {
        adapter = new ListaAlunosAdapter(context);
        listaDeAlunos.setAdapter(adapter);
    }
}
