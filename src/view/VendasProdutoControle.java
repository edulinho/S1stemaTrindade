/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import bean.EtsVendasProduto;
import java.util.List;
import javax.swing.table.AbstractTableModel;


public class VendasProdutoControle extends AbstractTableModel {

  
    List lista;


     public void setList(List lista) {
        this.lista = lista;
        this.fireTableDataChanged();
    }

   
    
    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

     public EtsVendasProduto getBean(int linha) {
        return (EtsVendasProduto) lista.get(linha);
    }
    
    public void addBean(EtsVendasProduto etsVendasProduto) {
            lista.add(etsVendasProduto);
            this.fireTableDataChanged();
    }
    
    public void removeBean(int index) {
            lista.remove(index);
            this.fireTableDataChanged();
    }
    
    public void updateBean(int index, EtsVendasProduto etsVendasProduto){
        lista.set(index, etsVendasProduto);
        this.fireTableDataChanged();
    }
    
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
       EtsVendasProduto vendasProduto = (EtsVendasProduto) lista.get(rowIndex);
        if (columnIndex == 0) {
            return vendasProduto.getEtsIdVendasProduto();
        }
        if (columnIndex == 1) {
            return vendasProduto.getEtsProduto();
        }
        if (columnIndex == 2) {
            return vendasProduto.getEtsQuantidade();
        }
        if (columnIndex == 3) {
            return vendasProduto.getEtsValorUnitario();
        }
        
        return "";
    }
//public Object getValueAt(int rowIndex, int columnIndex) {
 //   Object value = "";
  //  Object obj = lista.get(rowIndex);

  //  if (obj instanceof EtsVendasProduto) {
   //     EtsVendasProduto vendasProduto = (EtsVendasProduto) obj;

   //     switch (columnIndex) {
  //          case 0:
   //             value = vendasProduto.getEtsIdVendasProduto();
        //        break;
 //           case 1:
  //              value = vendasProduto.getEtsProduto();
   //             break;
   //         case 2:
 //               value = vendasProduto.getEtsQuantidade();
    //            break;
     //      case 3:
     //           value = vendasProduto.getEtsValorUnitario();
   //             break;
      //  }
  //  }

  //  return value;
//}
    
    
    
    @Override
    public String getColumnName(int columnIndex) {
        if (columnIndex == 0) {
            return "ID Venda Produto";
        }
        if (columnIndex == 1) {
            return "Produto";
        }
        if (columnIndex == 2) {
            return "Quantidade";
        }
        if (columnIndex == 3) {
            return "Valor Unitário";
        }
        
        return null;
    }
    
}
