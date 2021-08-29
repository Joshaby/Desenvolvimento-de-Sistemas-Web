package br.ifpb.edu;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

public class Banco {

    private static List<Empresa> empresaList = new ArrayList<>();
    private static Integer chaveSequencial = 1;

    static {
        Empresa empresa = new Empresa();
        empresa.setNome("IFPB CG");
        empresa.setId(chaveSequencial ++);
        Empresa empresa2 = new Empresa();
        empresa2.setId(chaveSequencial ++);
        empresa2.setNome("IFPB JP");
        empresaList.add(empresa);
        empresaList.add(empresa2);
    }

    public void adiciona(Empresa empresa) {
        empresa.setId(chaveSequencial ++);
        empresaList.add(empresa);
    }
    public List<Empresa> getEmpresaList() {
        return Banco.empresaList;
    }

    public void removeEmpresa(Integer id) {
        Iterator<Empresa> empresaIterator = empresaList.iterator();
        while(empresaIterator.hasNext()) {
            Empresa empresa = empresaIterator.next();
            if (empresa.getId().equals(id)) {
                empresaIterator.remove();
            }
        }
    }

    public Empresa buscaEmpresaPelaId(Integer id) {
        return empresaList.stream().filter(empresa -> empresa.getId().equals(id)).findFirst().orElse(null);
    }
}
