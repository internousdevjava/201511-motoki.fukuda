import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class KisoKadai3 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		String str;
		String file_name;
		String write;
		String dir_name;
		String folder_name;
		boolean flg = true;
		while (flg) {

			System.out.println("実行メニューを選択して下さい");
			System.out.println("[1]読込,[2]書込,[3]新規作成,[4]一覧表示,[99]終了");
			try {
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				str = br.readLine();
				int nu = 0;
				// 半角数値チェック
				if (str.matches("^[0-9]+$")) {
					nu = Integer.parseInt(str);
				} else {
					System.out.println("半角数値で入力して下さい");
				}
				// ファイル読み込み
				if (nu == 1) {
					System.out.println("読み込むファイルの宣言(絶対パス)[00]メニューに戻る");
					System.out.println("[例]c:\\xxxx\\xxxx\\xxx.txt");
					try {
						BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
						file_name = buff.readLine();
						if (file_name.equals("00")) {
							continue;
						}
						File file = new File(file_name);
						BufferedReader bf = new BufferedReader(new FileReader(file));

						while ((str = bf.readLine()) != null) {
							System.out.println("-----------------");
							System.out.println(str);
							System.out.println("-----------------");
						}
						bf.close();
					} catch (IOException e) {
						System.out.println(e);
					}
				}
				// ファイル書き込み
				else if (nu == 2) {
					System.out.println("書き込むファイルの宣言(絶対パス)[00]メニューに戻る");
					System.out.println("[例]c:\\xxxx\\xxxx\\xxx.txt");
					try {
						BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
						file_name = buff.readLine();
						if (file_name.equals("00")) {
							continue;
						}

						File file = new File(file_name);
						if (!file.exists()) {
							System.out.println("存在しません");
							continue;
						}
						if (file.isDirectory()) {
							System.out.println("ディレクトリが選択されています");
							continue;
						}
						System.out.println("[1]で上書き[2]で追記[00]メニューに戻る");
						try {
							BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
							str = buffer.readLine();
							if (str.equals("00")) {
								continue;
							}
							int num = 0;
							// 半角数値チェック
							if (str.matches("^[0-9]+$")) {
								num = Integer.parseInt(str);
							} else {
								System.out.println("半角数値で入力して下さい");
							}

							System.out.println("書き込む内容を入力[00]メニューに戻る");
							// 上書き
							if (num == 1) {
								try {
									PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file, false)));
									BufferedReader buffered = new BufferedReader(new InputStreamReader(System.in));
									write = buffered.readLine();
									if (write.equals("00")) {
										continue;
									}
									pw.println(write);
									pw.close();
								} catch (IOException e) {
									System.out.println(e);
								}
								// 追記
							} else if (num == 2) {
								;
								try {
									PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file, true)));
									BufferedReader buffered = new BufferedReader(new InputStreamReader(System.in));
									write = buffered.readLine();
									if (write.equals("00")) {
										continue;
									}
									pw.println(write);
									pw.close();
								} catch (IOException e) {
									System.out.println(e);
								}
							} else {
							}
						} catch (IOException e) {
							System.out.println(e);
						}
					} catch (IOException e) {
						System.out.println(e);
					}
				}
				// 新規作成
				else if (nu == 3) {
					try {
						System.out.println("作成ファイルの宣言(絶対パス)[00]メニューに戻る");
						System.out.println("パス内に作りたいディレクトリ名を宣言することで");
						System.out.println("ディレクトリも同時に作成されます");
						System.out.println("    [例]c:\\xxxx\\xxxx\\xxx.txt");
						System.out.println("ディレクトリのみ作成したい場合は[1]");
						BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
						file_name = buff.readLine();
						if (file_name.equals("1")) {
							// フォルダの作成
							System.out.println("作成するディレクトリの宣言(絶対パス)[00]メニューに戻る");
							BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
							folder_name = buffer.readLine();
							if (folder_name.indexOf(":") != -1 || folder_name.indexOf("/") != -1) {
								File file = new File(folder_name);
								// ディレクトリパスを取得する
								File dir = new File(file.getAbsolutePath());
								if (dir.exists()) {
									System.out.println("ディレクトリは既に存在します。");
								} else {
									System.out.println("ディレクトリがありません。:" + file.getAbsolutePath());
									dir.mkdirs();
									System.out.println("作成成功");
								}
							} else {
								System.out.println("絶対パスだって！！");
							}
						} else if (file_name.equals("00")) {
							continue;
						}

						else {
							// ファイルの作成
							File file = new File(file_name);
							// ディレクトリパスを取得する
							File dir = new File(file.getParent());

							if (!dir.exists()) {
								System.out.println("ディレクトリがありません。:" + file.getAbsolutePath());
								dir.mkdirs();
								System.out.println("ディレクトリが作成されました");
							} else {
								System.out.println("ディレクトリは既に存在します。");
							}

							if (file.exists()) {
								System.out.println("ファイルは既に存在します。\n" + file.getAbsolutePath());
							} else {
								System.out.println("ファイルは存在しません。\n" + file.getAbsolutePath());
								try {
									if (file.createNewFile()) {
										System.out.println("ファイルが作成されました");
									} else {
										System.out.println("作成失敗");
									}
								} catch (IOException e) {
									System.out.println(e);
								}
							}
						}
					} catch (Exception e) {
						System.out.println(e);
						System.out.println("絶対パスで宣言して下さい");
					}
				}

				else if (nu == 4) {
					// 一覧表示
					try {
						System.out.println("一覧を表示したいディレクトリを宣言(絶対パス)[00]メニューに戻る");
						System.out.println("[例]c:\\xxxx");
						BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
						dir_name = buff.readLine();
						if (dir_name.equals("00")) {
							continue;
						}
						File cdirectory = new File(dir_name + "\\");
						File filelist[] = cdirectory.listFiles();
						if (cdirectory.isFile()) {
							System.out.println("ファイルが選択されています");
							continue;
						}
						for (int i = 0; i < filelist.length; i++) {
							if (filelist[i].isFile()) {
								System.out.println("[F]" + filelist[i].getName());
							} else if (filelist[i].isDirectory()) {
								System.out.println("[D]" + filelist[i].getName());
							} else {
								System.out.println("[?]" + filelist[i].getName());
							}
						}
					} catch (Exception e) {
						System.out.println(e);
					}
				} else if (nu == 99) {
					break;
				} else {
					System.out.println("メニューに表示される数値から選択して下さい");
					continue;
				}
			} catch (FileNotFoundException e) {
				System.out.println(e);
			} catch (IOException e) {
				System.out.println(e);
			}
		}
		System.out.println("終了します");
		// ↑↑↑↑↑↑↑↑
	}
}