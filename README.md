# チーム開発方法

## Live shareを使ったデモ

### 概要

Live Shareでは複数人でソースを共有し、同時に編集することができます。
ホスト側（開発環境を立ち上げ、招待する側）とゲスト側（参加する側）に分かれ、ホストは自分の環境にゲストを招待します。<br>
<b>
* ホストはリーダーの人が担当し、対応を行ってください。<br>
* リーダー以外の人は、ゲストの対応を行ってください。<br>
</b>

### 招待手順

1. `ホスト`：Live Share起動
2. `ホスト`: url共有
3. `ゲスト`: sessionに参加
4. `ゲスト`: GitHubログイン
5. `ホスト・ゲスト`: Live Share起動確認

#### 1. `ホスト`：Live Share起動

ホスト（招待する人）のpcでCodespace起動後、左下の`Live Share`をクリックします。

![picture 1-1](images/978b5782dc3a54f26a77960dc46d94a5e4c33be6ec52103d8d24294e2d01aba5.png)

右下に起動中のアナウンス`Starting collaboration session`が表示されています。

![picture 1-2](images/9af0fda35ebc0d52b5310f9b4e9dd2bd9ac3db14f201f0be469a83dcb8b15745.png)

右下に`Invitaion link copied to clipboard! ～`が表示されると準備完了です。

![picture 1-3](images/541e29d48939b74244db95a631ec76e71eebc0e3b03cfab141259c352be3f24f.png)

#### 2. `ホスト`: url共有

1の手順終了後、すでにpcには招待用URLがコピーされています。
slackなどに貼り付け、メンバーにURLを共有してください。
（コピーに失敗した場合は`Copy again`をクリックしてください。）

#### 3. `ゲスト`: sessionに参加

ゲスト（参加メンバー）は共有されたURLをクリックすると、ブラウザでVS Codeが立ち上がります。
次のようなポップアップが表示された場合、`Continue in Web`を選択してください。

![picture 3-1](images/04975f0efd81ce65c00b54f91a83b9b75c62401852f179a3c0d01068a266cac2.png)

右下に、`Sign in with VS Live Share to a collaboration session.`が表示されるので、
`Sign in` をクリックしてください。

![picture 3-2](images/67b1bdeefe68837b51e495d09b93c64a58e70d4e10f0b0d725e724e81a8302a0.png)

上部にサインインするサービスの選択が現れるので、`GitHub`を選択します。

![picture 3-3](images/bb7fc15090b25090fe6191e68ceea6c75978487d8c100fda3f74ac4be9306549.png)

#### 4. `ゲスト`: GitHubログイン

GitHubログイン用のウィンドウが表示されます。
作成したアカウントを入力し、認証に進んでください。

![picture 4-1](images/8a00062fee8c4c3b22c30ca42d04d7b0e56901c40b2a0f52f95ec06766db367c.png)

ログイン後、しばらく時間をおいた後にブラウザのVSCodeの準備が完了したら終了です。

![picture 4-2](images/e050109304ea6fbbd19ebfb1d8086f59c7439f1930abfff00afd86802ba02886.png)

#### 5. `ホスト・ゲスト`: Live Share参加者確認

エクスプローラー（表示されていない場合は左上ファイルボタンをクリック）の下部にLIVE SHAREタブが現れます。
`Participants`に表示されるのが参加中のユーザーです。
全員参加しているか確認してみましょう。

![picture 5-1](images/2896962ee18e877f716526162c3da7fc8ae86625c9b3d2be9177e1cd7faa2cec.png)

### チーム開発Tips

#### フォロー機能：作業中のメンバーの動きを追いたい場合（ホスト・ゲスト）

Live Shareでは、あるユーザーの開いているファイルや編集中や選択中の箇所を自動で追いかけることができます。

エクスプローラーのLIVE SHAREの`Participants`内で、追いかけたいユーザー名をクリックし、名前左側の丸が塗りつぶされると追跡完了です。
解除したい場合は再度ユーザー名をクリックしてください。

![picture フォロー1](images/71afc2b587fbb47d06a95c273d9daefdd735f8ef693901ef7f7fee799de617ce.png) ![picture フォロー2](images/569817063033aa06f47b53521ea0ca35c83d898784ca78f71a05eb35af199074.png)



#### 実行したアプリケーションをメンバーで共有したい場合

実行したアプリケーションをメンバーの手元のpcで確認することができます。

1. `ホスト`の人がアプリケーションを実行します。
2. エディター下部の`ポート`を選択します。
3. ポート`8080`の上で右クリックし、`ポートの表示範囲`⇒`Public`を選択します。（画像参考）
4. 起動したアプリケーションのURLをslackなどでメンバーに共有します。

※注意：アプリケーションを停止すると、共有設定も初期化されます。
お手数ですが、アプリケーション再起動の際に再度共有設定をPublicに変更してください。

![picture アプリケーションの共有](images/5bd362d090b8c9daa96ee8d323c856319500f797dc2653db21d624da0d545f44.png)

---

## モブプロ実施方法補足

### コミット方法について

#### 概要

今回のモブプロでは各ターム（各順）終了時にソースをコミット(Commit)します。
コミットは、追加・変更したファイルをGitに登録するための操作です。
コミットは`ホスト`の方が行ってください。

#### 作業手順

##### 1. 木の枝のようなマークを押します。

![image](https://user-images.githubusercontent.com/32722128/149911899-77da4cf0-cf8e-4b74-af63-1592156f4e9c.png)

##### 2. これまでに行ったファイルへの変更ないようが表示されています。

変更内容に問題がないか今一度確認しましょう。
![image](https://user-images.githubusercontent.com/32722128/149912420-00d3f65f-d50c-4b78-a0d6-1dfae21389f1.png)

##### 3. コミットするファイルを選択しましょう。

コミットしたいファイルの横の＋ボタンを押しましょう。
![image](https://user-images.githubusercontent.com/32722128/149912930-bd2d559c-0456-41d0-82bc-aa32376ad3c4.png)

##### 4. Staged Changesにコミットしたいファイルが含まれていることを確認しましょう。

![image](https://user-images.githubusercontent.com/32722128/149913113-2b2f3b32-ea97-41f6-b805-60dd5b05d2dc.png)

##### 5. Message欄にCommit Message(コミットメッセージ)を入力しましょう。

* Commit Messageには、今回のコミットの追加・変更内容について記載します。
* ※モブプロでは、**ナビゲーターの名前**を記載してください！

![image](https://user-images.githubusercontent.com/32722128/149915153-848dd391-5a21-4581-a2f8-a1f635f97386.png)

##### 6. チェックボタンを押してコミットしましょう。

![image](https://user-images.githubusercontent.com/32722128/149915586-633c9a2f-06e4-4815-89f3-3008bfe4cfdc.png)


---

## モブプロ実践
### LiveShareを使って以下の課題を実施してください
* 練習.txtを以下の流れで更新する
  * ナビゲーターがドライバーに指示を出します。
    * ナビゲーターの好きなもの（食べ物、趣味、アニメ、ゲームなど）を伝える
    * ドライバーはその指示を聞いて練習.txtに入力する
* 入力が終わったら、リーダー（ホスト）はナビゲーターの名前でコミットする
* チームメンバー全員分だけ繰り返し行ってください
* 上記の作業は、リーダー（ホスト）の人が常にLiveShareの共有を使って実施してください
