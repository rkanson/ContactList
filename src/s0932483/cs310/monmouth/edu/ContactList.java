/**
 * Richard Kanson
 * Nov 22, 2016
 * ContactList
 */
package s0932483.cs310.monmouth.edu;

import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.*;

public class ContactList {

	static boolean lang = false;
	static JTextField filename = new JTextField();
	static JTextField dir = new JTextField();
	static Locale currentLocale;
	static ResourceBundle bundle;
	static ArrayList<Contact> allContacts = new ArrayList<Contact>();
	private static final Logger logger = Logger.getLogger(ContactList.class.getName());

	public static void main(String[] args) {
		if (lang == false) {
			selectLocale();
			JFrame main = new JFrame(bundle.getString("mWindowTitle"));
			GridLayout gridLayout = new GridLayout(3, 1);
			JPanel mainPanel = new JPanel();
			mainPanel.setLayout(gridLayout);
			JMenuBar menuBar;
			JMenu file, preferences;
			JMenuItem newWindow, open, save, saveas, about, exit, language;
			JButton add, view, search;
			menuBar = new JMenuBar();
			file = new JMenu(bundle.getString("file"));
			preferences = new JMenu(bundle.getString("preferences"));
			menuBar.add(file);
			menuBar.add(preferences);
			newWindow = new JMenuItem(bundle.getString("new"));
			newWindow.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent event) {
					addContact();
				}
			});
			open = new JMenuItem(bundle.getString("open"));
			open.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent event) {
					JFileChooser fc = new JFileChooser();
					int returnVal = fc.showOpenDialog(fc);
					if (returnVal == JFileChooser.APPROVE_OPTION) {
						File file = fc.getSelectedFile();
						String fName = file.getName();
						openFile(fName);
					}
				}
			});
			save = new JMenuItem(bundle.getString("save"));
			save.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent event) {
				}
			});
			saveas = new JMenuItem(bundle.getString("saveas"));
			saveas.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent event) {
					saveAsFile();
				}
			});
			about = new JMenuItem(bundle.getString("about"));
			about.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent event) {
					aboutWindow();
				}
			});
			exit = new JMenuItem(bundle.getString("exit"));
			exit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent event) {
					System.exit(0);
				}
			});
			language = new JMenuItem(bundle.getString("language"));
			language.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent event) {
					selectLocale();
					lang = true;
					main.dispose();
					main(args);
				}
			});
			file.add(newWindow);
			file.add(open);
			file.add(save);
			file.add(saveas);
			file.add(about);
			file.add(exit);
			preferences.add(language);
			main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			main.setSize(300, 400);
			main.setJMenuBar(menuBar);
			main.add(mainPanel);
			mainPanel.add(add = new JButton(bundle.getString("addContact")));
			add.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent event) {
					addContact();
				}
			});
			mainPanel.add(view = new JButton(bundle.getString("viewContacts")));
			view.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent event) {
					viewContacts();
				}
			});
			mainPanel.add(search = new JButton(bundle.getString("searchContacts")));
			search.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent event) {
					searchContacts();
				}
			});
			main.setVisible(true);
		} else {
			JFrame main = new JFrame(bundle.getString("mWindowTitle"));
			GridLayout gridLayout = new GridLayout(3, 1);
			JPanel mainPanel = new JPanel();
			mainPanel.setLayout(gridLayout);
			JMenuBar menuBar;
			JMenu file, preferences;
			JMenuItem newWindow, open, save, saveas, about, exit, language;
			JButton add, view, search;
			menuBar = new JMenuBar();
			file = new JMenu(bundle.getString("file"));
			preferences = new JMenu(bundle.getString("preferences"));
			menuBar.add(file);
			menuBar.add(preferences);
			newWindow = new JMenuItem(bundle.getString("new"));
			newWindow.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent event) {
					addContact();
				}
			});
			open = new JMenuItem(bundle.getString("open"));
			open.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent event) {
					JFileChooser fc = new JFileChooser();
					int returnVal = fc.showOpenDialog(fc);
					if (returnVal == JFileChooser.APPROVE_OPTION) {
						File file = fc.getSelectedFile();
						String fName = file.getName();
						openFile(fName);
					}
				}
			});
			save = new JMenuItem(bundle.getString("save"));
			save.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent event) {
				}
			});
			saveas = new JMenuItem(bundle.getString("saveas"));
			saveas.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent event) {
					saveAsFile();
				}
			});
			about = new JMenuItem(bundle.getString("about"));
			about.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent event) {
					aboutWindow();
				}
			});
			exit = new JMenuItem(bundle.getString("exit"));
			exit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent event) {
					System.exit(0);
				}
			});
			language = new JMenuItem(bundle.getString("language"));
			language.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent event) {
					selectLocale();
					lang = true;
					main.dispose();
					main(args);
				}
			});
			file.add(newWindow);
			file.add(open);
			file.add(save);
			file.add(saveas);
			file.add(about);
			file.add(exit);
			preferences.add(language);
			main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			main.setSize(300, 400);
			main.setJMenuBar(menuBar);
			main.add(mainPanel);
			mainPanel.add(add = new JButton(bundle.getString("addContact")));
			add.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent event) {
					addContact();
				}
			});
			mainPanel.add(view = new JButton(bundle.getString("viewContacts")));
			view.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent event) {
					viewContacts();
				}
			});
			mainPanel.add(search = new JButton(bundle.getString("searchContacts")));
			search.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent event) {
					searchContacts();
				}
			});
			main.setVisible(true);
		}
	}

	public static void addContact() {
		JFrame addFrame = new JFrame(bundle.getString("addContact"));
		JPanel addPanel = new JPanel();
		FlowLayout addLayout = new FlowLayout(FlowLayout.CENTER);
		JTextField id = new JTextField(15);
		JTextField fName = new JTextField(15);
		JTextField lName = new JTextField(15);
		JTextField number = new JTextField(15);
		JButton save;
		JButton clear;
		JButton close;
		addPanel.setLayout(addLayout);
		addFrame.setSize(200, 400);
		addFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		addFrame.add(addPanel);
		addPanel.add(new JLabel(bundle.getString("id")));
		addPanel.add(id);
		addPanel.add(new JLabel(bundle.getString("first")));
		addPanel.add(fName);
		addPanel.add(new JLabel(bundle.getString("last")));
		addPanel.add(lName);
		addPanel.add(new JLabel(bundle.getString("number")));
		addPanel.add(number);
		addPanel.add(clear = new JButton(bundle.getString("clear")));
		clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				id.setText(" ");
				fName.setText(" ");
				lName.setText(" ");
				number.setText(" ");
			}
		});
		addPanel.add(save = new JButton(bundle.getString("saveContact")));
		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				if (id.getText().isEmpty() | fName.getText().isEmpty() | lName.getText().isEmpty()
						| number.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, bundle.getString("inputValid"));
				} else if (id.getText().matches("[0-9]+") && fName.getText().matches("[a-zA-Z]+")
						&& lName.getText().matches("[a-zA-Z]+")
						&& number.getText().matches("[0-9]{3}-[0-9]{3}-[0-9]{4}")) {
					saveContact(id.getText(), fName.getText(), lName.getText(), number.getText());
				} else {
					JOptionPane.showMessageDialog(null, bundle.getString("inputEmpty"));
					logger.log(Level.INFO, bundle.getString("logAdd"));
				}
				addFrame.dispose();
			}
		});
		addPanel.add(close = new JButton(bundle.getString("close")));
		close.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				addFrame.dispose();
			}
		});
		addFrame.setVisible(true);
	}

	public static void viewContacts() {
		Collections.sort(allContacts, Contact.ContactNameComparator);
		JFrame viewFrame = new JFrame(bundle.getString("viewContacts"));
		JPanel viewPanel = new JPanel();
		JButton close;
		viewPanel.setLayout(new BoxLayout(viewPanel, BoxLayout.Y_AXIS));
		viewFrame.setSize(300, 400);
		viewFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		viewFrame.add(viewPanel);
		viewPanel.add(close = new JButton(bundle.getString("close")));
		close.setAlignmentX(Component.CENTER_ALIGNMENT);
		close.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				viewFrame.dispose();
			}
		});
		for (Contact c : allContacts) {
			JLabel contacts;
			JButton edit;
			viewPanel.add(contacts = new JLabel((c.getFirst() + " " + c.getLast() + ", " + c.getNumber()),
					SwingConstants.CENTER));
			contacts.setAlignmentX(Component.CENTER_ALIGNMENT);
			viewPanel.add(edit = new JButton(bundle.getString("edit")));
			edit.setAlignmentX(Component.CENTER_ALIGNMENT);
			edit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent event) {
					int i = c.getID() - 1;
					String f = c.getFirst();
					String l = c.getLast();
					String n = c.getNumber();
					editContact(i, f, l, n);
					viewFrame.dispose();
				}
			});
		}
		JScrollPane scroller = new JScrollPane(viewPanel);
		viewFrame.getContentPane().add(scroller);
		viewFrame.setVisible(true);
	}

	public static void searchContacts() {
		JFrame searchFrame = new JFrame(bundle.getString("searchContacts"));
		JPanel searchPanel = new JPanel();
		FlowLayout searchLayout = new FlowLayout(FlowLayout.CENTER);
		JTextField keyword = new JTextField(15);
		JButton search;
		JButton clear;
		JButton close;
		searchPanel.setLayout(searchLayout);
		searchFrame.setSize(300, 400);
		searchFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		searchFrame.add(searchPanel);
		searchPanel.add(new JLabel(bundle.getString("search")));
		searchPanel.add(keyword);
		searchPanel.add(search = new JButton(bundle.getString("search")));
		search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				for (Contact c : allContacts) {
					if (c.getFirst().contains(keyword.getText()) | c.getLast().contains(keyword.getText())
							| c.getNumber().contains(keyword.getText())) {
						searchPanel.add(new JLabel((c.getFirst() + " " + c.getLast() + ", " + c.getNumber())));
						searchFrame.revalidate();
						searchFrame.repaint();
						search.setEnabled(false);
					}
				}
			}
		});
		searchPanel.add(clear = new JButton(bundle.getString("clear")));
		clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				searchFrame.dispose();
				searchContacts();
			}
		});
		searchPanel.add(close = new JButton(bundle.getString("close")));
		close.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				searchFrame.dispose();
			}
		});
		searchFrame.setVisible(true);
	}

	public static void saveContact(String sID, String fName, String lName, String number) {
		int id = Integer.parseInt(sID);
		Contact newContact = new Contact(id, fName, lName, number);
		allContacts.add(newContact);
	}

	public static void loadContacts(String fileName) {
		String csvFile = "resources/" + fileName;
		String line = "";
		String csvSplitBy = ",";

		try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

			while ((line = br.readLine()) != null) {

				String[] contact = line.split(csvSplitBy);
				String sID = contact[0];
				int id = Integer.parseInt(sID);
				String fName = contact[1];
				String lName = contact[2];
				String number = contact[3];
				Contact newContact = new Contact(id, fName, lName, number);
				allContacts.add(newContact);

			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void editContact(int i, String f, String l, String n) {
		JFrame editFrame = new JFrame(bundle.getString("edit"));
		JPanel editPanel = new JPanel();
		FlowLayout editLayout = new FlowLayout(FlowLayout.CENTER);
		JTextField fName = new JTextField(f);
		JTextField lName = new JTextField(l);
		JTextField number = new JTextField(n);
		JButton save;
		JButton delete;
		JButton close;
		editPanel.setLayout(editLayout);
		editFrame.setSize(160, 400);
		editFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		editFrame.add(editPanel);
		editPanel.add(new JLabel(bundle.getString("first")));
		editPanel.add(fName);
		editPanel.add(new JLabel(bundle.getString("last")));
		editPanel.add(lName);
		editPanel.add(new JLabel(bundle.getString("number")));
		editPanel.add(number);
		editPanel.add(save = new JButton(bundle.getString("saveContact")));
		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				if (fName.getText().isEmpty() | lName.getText().isEmpty() | number.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, bundle.getString("inputEmpty"));
				} else {
					updateContact(i, fName.getText(), lName.getText(), number.getText());
				}
				editFrame.dispose();
			}
		});
		editPanel.add(delete = new JButton(bundle.getString("delete")));
		delete.setAlignmentX(Component.CENTER_ALIGNMENT);
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				deleteContact(i);
				editFrame.dispose();
			}
		});
		editPanel.add(close = new JButton(bundle.getString("close")));
		close.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				editFrame.dispose();
			}
		});
		editFrame.setVisible(true);
	}

	public static void updateContact(int i, String f, String l, String n) {
		Contact updatedContact = new Contact(i, f, l, n);
		allContacts.set(i, updatedContact);
		logger.log(Level.INFO, bundle.getString("logUpdate"));
	}

	public static void deleteContact(int i) {
		allContacts.remove(i);
		logger.log(Level.INFO, bundle.getString("logDelete"));
	}

	public static void aboutWindow() {
		JOptionPane.showMessageDialog(null,
				bundle.getString("author") + ": Richard Kanson" + "\n" + bundle.getString("date") + ": 11/22/2016"
						+ "\n" + bundle.getString("version") + ": 1.0",
				bundle.getString("aboutTitle"), JOptionPane.PLAIN_MESSAGE);
	}

	public static void openFile(String fName) {
		allContacts.clear();
		loadContacts(fName);
		JOptionPane.showMessageDialog(null, bundle.getString("openLoaded"));
	}

	public static void selectLocale() {
		Object[] options = { "Espanol", "English" };
		int n = JOptionPane.showOptionDialog(null, "Please Select a Language", "Language", JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
		if (n == JOptionPane.NO_OPTION) {
			Locale en_US = new Locale("en", "US");
			bundle = ResourceBundle.getBundle("resources.MessagesBundle_en_US", en_US);
		} else if (n == JOptionPane.YES_OPTION) {
			Locale es_MX = new Locale("es", "MX");
			bundle = ResourceBundle.getBundle("resources.MessagesBundle_es_MX", es_MX);
		}
	}

	public static void saveFile() {
		JFileChooser fc = new JFileChooser();
		int returnVal = fc.showSaveDialog(fc);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			filename.setText(fc.getSelectedFile().getName());
			dir.setText(fc.getCurrentDirectory().toString());
		}
	}

	public static void saveAsFile() {
		JFileChooser fc = new JFileChooser();
		int returnVal = fc.showSaveDialog(fc);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			filename.setText(fc.getSelectedFile().getName());
			dir.setText(fc.getCurrentDirectory().toString());
		}
	}
}
