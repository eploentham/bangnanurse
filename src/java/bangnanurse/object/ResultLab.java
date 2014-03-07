/*
 * result_lab.java
 *
 * Created on 18 ���Ҥ� 2546, 18:03 �.
 */

package bangnanurse.object;
/**
 *
 * @author  tong
 */

public class ResultLab {       
    /**
     *@deprecated henbe unused ������Ţ���� �������������Ţ lab result_item �͹�����ԡ��ҹ����
     */
       public String  patient_id;
       public String  visit_id;
       public String  order_item_id;
       public String  result;
       public String result_old;//pop
       public String  unit;
       public String  reporter;
       public String  reported_time;
       public String  name;
       public String  active;
       public String  result_complete ;
       public String  item_id;
       public String  result_type_id;
       public String  min;
       public String  max;
       public String  result_group_id;
       public String  index;
       public String  lab_result_item_id;
       public String  flag = "";
       public String  status_approve = "";//pop
       public String approved_staff_record="";//pop

    /** Creates a new instance of result_lab */

    public ResultLab() {
       patient_id = "";
       visit_id = "";
       order_item_id = "";
       result = "";
       unit = "";
       reporter = "";
       reported_time = "";
       name = "";
       active = "";
       result_complete  = "";
       item_id = "";
       result_type_id = "";
       min = "";
       max = "";
       result_group_id = "";
       index = "";
       lab_result_item_id = "";
       flag = "";
       result_old = "";//pop
       status_approve="";//pop
       approved_staff_record="";//pop
    }   
}
