package com.cursoandroid.agenda;

import android.app.Application;

import com.cursoandroid.agenda.DAO.AlunoDAO;
import com.cursoandroid.agenda.model.Aluno;

public class AgendaApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        criaAlunoDeTeste();
    }

    private void criaAlunoDeTeste() {
        AlunoDAO dao = new AlunoDAO();
        dao.salva(new Aluno("Larissa", "222222", "larissa@aluno.com"));
        dao.salva(new Aluno("Malu", "222222", "malu@aluno.com"));
    }
}
