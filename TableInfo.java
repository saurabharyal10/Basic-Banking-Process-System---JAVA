package banking_pro;

import java.util.List;
import java.util.Map;
import javax.swing.JTable;

public class TableInfo {
	public static JTable getTableUI() {
		
		List<Map<String, String>> data = JDBCConnectionPart.getList();
		
		String[] columnNames = {"S.No.", "First Name","Last Name","Username","Password","Address"
								,"Contact","Gender","Balance"}; 

		String[][] cells = new String[data.size()][10];
		for(int i = 0; i<data.size(); i++) {
			Map<String, String> row = data.get(i);
			cells[i][0] = row.get("sNo");
			cells[i][1] = row.get("firstname");
			cells[i][2] = row.get("lastname");
			cells[i][3] = row.get("username");
			cells[i][4] = row.get("password");
			cells[i][5] = row.get("address");
			cells[i][6] = row.get("contact");
			cells[i][7] = row.get("gender");
			cells[i][8] = row.get("balance");
		}

		JTable table = new JTable(cells, columnNames);
		return table;

	}
	
}

