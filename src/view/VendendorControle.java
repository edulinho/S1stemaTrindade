/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import bean.EtsVendendor;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import bean.EtsVendendor;

/**
 *
 * @author eduardo
 */
public class VendendorControle extends AbstractTableModel{
     List lista;

    public void setList(List lista){
    this.lista = lista;
     this.fireTableDataChanged();
    };
    public EtsVendendor getBean(int row){
    return (EtsVendendor)lista.get(row);
    }

    @Override
    public int getRowCount() {
       return lista.size();
    }

    @Override
    public int getColumnCount() {
return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
     EtsVendendor etsVendendor = (EtsVendendor) lista.get(rowIndex);
        if (columnIndex == 0){
        return etsVendendor.getEtsIdvendendor();
        }
        if (columnIndex == 1){
        return etsVendendor.getEtsComissao();
        }
        if (columnIndex == 2){
        return etsVendendor.getEtsArea();
        }
        if (columnIndex == 3){
        return etsVendendor.getEtsTelefone();
        }
        return "";
    }

    @Override
    public String getColumnName(int column){
        if (column == 0){
        return "id";
        }
        if (column == 1){
        return "comissao";
        }
        if (column == 2){
        return "area";
        }
        if (column == 3){
        return "telefone";
        }

        return "";
    };
}
