<outline>
標準ライブラリのみを用いて、RSA暗号のアルゴリズムを作成した。

<contents>
Main.java → mainメソッドが含まれている
Sender.java → 送信者に見立てたクラス
Reciever.java → 受信者に見立てたクラス
resources/Data.txt → サンプルテキストファイル
resources/PrimeNumber.txt → 1~10000までの素数表。桁の大きいものを消すことで高速化ができる。

<commands>
Main.javaを動かすと、初めにScannerによる入力待ちが発生する。
  
①数字を暗号化する
0 [暗号化したい数字]
-example-
0 6
→ send:6
  recieve:6

②1文字(char型)を暗号化する
1 [暗号化したい文字]
-example-
1 a
→ send:a
  recieve:a

③テキストファイルを全て暗号化する
2 [暗号化したいテキストファイルの、Main.classから見た相対パス]
-example-
2 ./resources/Data.txt 
→ [テキストファイル内の文字列が表示される]

＊注意＊
③に関してはアルゴリズムの構造上非常に動作が遅いため、resources/PrimeNumber.txt内の素数の内１０００以上のものを消すことを推奨
