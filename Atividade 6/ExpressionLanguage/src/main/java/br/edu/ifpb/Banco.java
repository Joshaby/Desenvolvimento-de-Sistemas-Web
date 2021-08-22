package br.edu.ifpb;

import java.util.List;
import java.util.ArrayList;

public class Banco {

    private static List<Empresa> empresaList = new ArrayList<>();

    public void adiciona(Empresa empresa) {
        empresaList.add(empresa);
    }
    public List<Empresa> getEmpresaList() {
        return Banco.empresaList;
    }
}
