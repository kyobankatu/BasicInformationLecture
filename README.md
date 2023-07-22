## outline
標準ライブラリのみを用いて、RSA暗号のアルゴリズムを作成した。

## contents
Main.java → mainメソッドが含まれている<br>
Sender.java → 送信者に見立てたクラス<br>
Reciever.java → 受信者に見立てたクラス<br>
resources/Data.txt → サンプルテキストファイル<br>
resources/PrimeNumber.txt → 1~46340までの素数表。桁の大きいものを消すことで高速化ができる。<br>

## commands
Main.javaを動かすと、初めにScannerによる入力待ちが発生する。
  
### ①数字を暗号化する
0 [暗号化したい数字] <br>

-example-
```
0 6
→ send:6
  recieve:6
```

### ②1文字(char型)を暗号化する
1 [暗号化したい文字] <br>

-example-
```
1 a
→ send:a
  recieve:a
```

### ③テキストファイルを全て暗号化する
2 [暗号化したいテキストファイルの、Main.classから見た相対パス] <br>

-example-
```
2 ./resources/Data.txt 
→ [テキストファイル内の文字列が表示される]
```