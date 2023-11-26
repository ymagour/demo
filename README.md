# 【Level0】既存プログラムを理解しよう
## テーマ
1. MVCモデルについて理解しよう 
1. Springを使った開発について理解しよう
1. データベースの利用について(H2 Database)


## 開発環境について
* 本演習では、Codespacesと呼ばれるサービスを使って開発を行います。
* ブラウザ上で動作する開発環境です、インストール不要で使う事ができます。

## まずは動かしてみよう
1. Codeをクリックします。  
![image](https://user-images.githubusercontent.com/93235101/149875383-0394aed2-2635-46e1-a3d3-6b0ad9c898b1.png)

1. 矢印で示した箇所を押してください。  
初回と、2回目以降では表示が異なりますので注意してください。  
【初回】<br>
![image](https://user-images.githubusercontent.com/98931339/197378390-fc942658-a2f3-48b2-9a6a-0abcdf3eacc4.png)<br>
![image](https://user-images.githubusercontent.com/98931339/197378431-8afbc127-f9c4-495d-aeca-8d0b0cc3a4a3.png)<br>
![image](https://user-images.githubusercontent.com/98931339/197378472-2f813cf8-2a83-4159-8ef9-70386d5756c5.png)<br>
![image](https://user-images.githubusercontent.com/98931339/197378516-95472915-47a7-4635-b9c5-d948210a9a2c.png)<br>
![image](https://user-images.githubusercontent.com/98931339/197378546-562b69ce-35e1-4e1a-bfd3-a710a4954701.png)<br>


【2回目以降】<br>
![image](https://user-images.githubusercontent.com/32722128/189561560-62912db3-e459-4866-8ac6-f199fbee89bd.png)

1. しばらく待ちます。  
![image](https://user-images.githubusercontent.com/93235101/149875470-df4edec6-eba7-4431-8ee4-c474c198ea45.png)

1. 画像のダイアログが表示されたら、インストールを押してください。  
![image](https://user-images.githubusercontent.com/32722128/189562730-6a5e3736-627c-42c9-a8ac-70a28431a2cf.png)

1. インストールボタンを押すと、新しいタブが開きます。緑で囲んだ部分が`無効にする`になったらタブを閉じましょう。  
![image](https://user-images.githubusercontent.com/32722128/189563734-b0bb90af-6c8a-4d9a-a805-155fac5ed073.png)

1. `作業の開始`タブも閉じましょう。  


1. `実行とデバッグ`アイコンを押します。  
![image](https://user-images.githubusercontent.com/93235101/149875480-b6d0189c-52f3-45dd-bcc3-335bff5d76d0.png)

1. `Launch AssignmentApplication`が選択されていることを確認し再生ボタンを押します。  初回はダイアログが表示されます、YESを選択してください。  
![image](https://user-images.githubusercontent.com/93235101/149875513-ded6ea34-792e-40da-927e-215d7e22bbf2.png)
![image](https://user-images.githubusercontent.com/93235101/149875530-d1437647-e1ac-44bf-a785-36615ae83e6f.png)

1. `Open in Browser`を押します。(表示されるまでしばらく時間が掛かります。)  
![image](https://user-images.githubusercontent.com/93235101/149875545-6689fe73-7a32-4be8-8658-eaf8c8ddd460.png)

1. Webページが表示されます。  
![image](https://user-images.githubusercontent.com/98931339/197379614-62032f37-fd16-47e6-bcfb-33ac5dd50fc1.png)

1. 確認が終わったら、タブを閉じましょう  

1. デバック実行中ですので、停止ボタンを押して、デバック実行を停止しましょう。 
![image](https://user-images.githubusercontent.com/98931339/197379780-b0604c4e-ce9a-4e88-a856-0926323dd758.png)

# MVCモデルについて理解しよう 
MVCは、今回皆さんに学んで頂くSpring BootなどのWebフレームワークで一般的に取り入れられるWebアプリケーション構築を整理するための概念の一つです。
3つの要素を組み合わせる事で、Webアプリケーションを構築します。
この3つの要素というのは、モデル（Model）、ビュー（View）、コントローラー（Controller）の事で、これらの頭文字を取ってMVCと呼ばれています。

## モデルとは
Webアプリケーション内のビジネスロジックを担当します。

## ビューとは
ブラウザ上で表示可能なHTMLを構築し、クライアントへレスポンスを送信します。

## コントローラーとは
モデルとビューの橋渡しを行っています。

# 今回のプログラムにおけるMVC
## モデル
ServiceクラスやDaoクラスを指します。

## ビュー
Thymeleafなどのテンプレートエンジンを利用して、HTMLを生成する部分を指します。

## コントローラー
Controllerクラスを指します。

# ページが表示される仕組みについて
授業管理ページを表示する際の動作を例に説明します。
1. ユーザー：Lessonボタンを押します。
1. ブラウザ：Lessonボタンが押されたので、パス`/lesson`にGETリクエストを送信します。
1. Webサーバー(Spring Boot)：`/lesson`にGETリクエストが来たので、対応するコントローラーである`LessonController`クラスの`index`メソッドに処理を任せます。
1. コントローラー：サービスである`LessonService`クラスの`selectAll`メソッドを使って、授業一覧データを取得しようとします。
1. サービス：Daoである`LessonDao`クラスの`selectAll`メソッド使って、授業一覧データを取得します。
1. Dao：データベースから授業一覧データを取得し、サービスへ返します。
1. サービス：Daoから受け取った授業一覧データをコントローラーへ返します。
1. コントローラー：受け取った授業一覧データと使用するテンプレート名をテンプレートエンジンに渡します。
1. テンプレートエンジン：指定されたテンプレートと授業一覧データを組合せてHTMLを生成します。
1. Webサーバー(Spring Boot)：ブラウザに対して生成されたHTMLを返します。
1. ブラウザ：受け取ったHTMLを表示します。


# 解説
## コントローラーの動き
* WEBページのリンクボタン(他のページに移動するボタン)を押すと、ブラウザからリクエストが送信されます。
* リクエストには移動先のページのURLが含まれています。

* URLの例
![image](https://user-images.githubusercontent.com/32722128/151471031-ac57fa7a-646d-4464-b5a3-60e881cf07c6.png)

* このURLで指定されるパス(ディレクトリ名)によって、処理されるクラス、メソッドが指定されます。  
リクエストは最初にコントローラーで処理されます。
* どのパスに対するリクエストをどのクラスのどのメソッドに処理させるのかは、`@RequestMapping`、`@GetMapping`などのアノテーションで指定されています。
* 今回の演習の対象である、`LessonController`クラスには`@RequestMapping("/lesson")`というアノテーションが指定されています。
* これは`/lesson`というパスに対して送られたリクエストを`LessonController`クラスにて処理する事を指定しています。
* また`index`メソッドには、`@GetMapping`とアノテーションがついていますが、これはHTTPリクエストメソッドがGETの場合は、`index`メソッドでリクエストを受け付ける事を指定しています。
![image](https://user-images.githubusercontent.com/32722128/189564588-5cb2d7f9-d1c3-47f5-b1e5-9844c993d32c.png)  
[参考資料：HTTPリクエストメソッドについて](https://wa3.i-3-i.info/word11405.html)

* `index`メソッドはサービスである`lessonService`クラスの`selectAll`メソッドを利用して、授業のリストを取得しています。
* model.addAttributeメソッドを使用して、画面表示したいデータとその属性名をmodelに指定しています。  
model.addAttributeメソッドの第一引数に属性名、第二引数に渡したいデータを指定しています。　　
* 戻り値として、使用したいView名を指定する事で、テンプレートエンジン(Thymeleaf)の処理に移ります。
* テンプレートエンジンでは先ほどmodelに指定されたデータを取り出し、指定された属性名の部分にデータを展開します。 

# サービスクラスの動き
* サービスクラスはビジネスロジックを記載するクラスです、今回は`LessonService`クラスの`selectAll`メソッドが使用されています。
* `LessonService`クラスの`selectAll`メソッドから、Daoである`ArchievementDao`クラスの`selectAll`メソッドを呼び出して、`Lesson`クラスのオブジェクトのリスト取得し、コントローラーへ返却しています。

### サービスクラス `archievementDao.selectAll`メソッド
```
 public List<Lesson> selectAll() {
    List<Lesson> list = dao.selectAll();
    return list;
  }
```

# Daoクラスとは
Daoは、Data Access Objectの略称でデータベース操作を担当するクラスです。

### Daoクラス`ArchievementDao`

```
@Override
public List<Lesson> selectAll() {
String sql = "SELECT id, name, day, period, teacher FROM LESSON";
List<Map<String, Object>> resultList = jdbcTemplate.queryForList(sql);
List<Lesson> list = new ArrayList<Lesson>();
for (Map<String, Object> result : resultList) {
  Lesson lesson = new Lesson();
  lesson.setId((int) result.get("id"));
  lesson.setName((String) result.get("name"));
  lesson.setPeriod((int) result.get("period"));
  lesson.setTeacher(((String) result.get("teacher")));

  int day = (int) result.get("day");
  lesson.setDay(day);
  // 曜日番号 → 曜日名 変換
  lesson.setDayName(DayOfWeek.of(day).getDisplayName(TextStyle.SHORT, Locale.JAPAN));

  list.add(lesson);
}

return list;
}
```
SQL文を用いて、LESSONテーブルから`jdbcTemplate.queryForList`メソッドを利用してデータを取得しています。  
Map型で取得されますので、LessonクラスのList型オブジェクトに変換し、Serviceクラスへ値を返却しています。


# テンプレートエンジンとは
今回の授業では、Spring Bootでの使用が推奨されている、Thymeleaf(タイムリーフ)というテンプレートエンジンを使用しています。  
テンプレートエンジンとは、データとテンプレートを合体させ文字列を作る仕組みの事です。  
生成したHTMLをブラウザに応答し、ブラウザがHTMLを解釈しWEBページの表示を行っています。
今回は`lesson/index`のテンプレートを利用しています。

### テンプレート`lesson/index`(一部抜粋)
  
```
<table class="table">
  <thead>
    <tr>
      <th scope="col">id</th>
      <th scope="col">授業名</th>
      <th scope="col">曜日</th>
      <th scope="col">担当</th>
      <th scope="col"></th>
    </tr>
  </thead>
  <tbody>
    <tr th:each="lesson : ${lessonList}">
      <td th:text="${lesson.id}" scope="row"></td>
      <td th:text="${lesson.name}"></td>
      <td th:text="${lesson.dayName}+${lesson.period}">
      </td>
      <td th:text="${lesson.teacher}"></td>
      <td>
        <a class="btn btn-info rounded-circle p-0 pt-1" th:href="@{/lesson/detail/{id}(id=${lesson.id})}"
          style="width:2rem; height:2rem;">
          <i class="bi bi-pencil-fill"></i>
        </a>
        <a class="btn btn-outline-secondary rounded-circle p-0 pt-1"
          th:href="@{/lesson/delete?id={id}(id=${lesson.id})}" style="width:2rem; height:2rem;">
          <i class="bi bi-trash-fill"></i>
        </a>
      </td>
    </tr>
  </tbody>
</table>
```

### 生成されたHTML(一部抜粋)

```
<table class="table">
  <thead>
    <tr>
      <th scope="col">id</th>
      <th scope="col">授業名</th>
      <th scope="col">曜日</th>
      <th scope="col">担当</th>
      <th scope="col"></th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td scope="row">1</td>
      <td>lesson1</td>
      <td>月1</td>
      <td>○○</td>
      <td>
        <a class="btn btn-info rounded-circle p-0 pt-1" href="/lesson/detail/1"
          style="width:2rem; height:2rem;">
          <i class="bi bi-pencil-fill"></i>
        </a>
        <a class="btn btn-outline-secondary rounded-circle p-0 pt-1"
          href="/lesson/delete?id=1" style="width:2rem; height:2rem;">
          <i class="bi bi-trash-fill"></i>
        </a>
      </td>
    </tr>
    <tr>
      <td scope="row">2</td>
      <td>lesson2</td>
      <td>月2</td>
      <td>○○</td>
      <td>
        <a class="btn btn-info rounded-circle p-0 pt-1" href="/lesson/detail/2"
          style="width:2rem; height:2rem;">
          <i class="bi bi-pencil-fill"></i>
        </a>
        <a class="btn btn-outline-secondary rounded-circle p-0 pt-1"
          href="/lesson/delete?id=2" style="width:2rem; height:2rem;">
          <i class="bi bi-trash-fill"></i>
        </a>
      </td>
    </tr>
  </tbody>
</table>
```
* `th:each="変数 : ${コレクション}"`と記載する事で、`${コレクション}`の値を1つずつ取り出し変数に代入し、以降の処理の中で「変数.フィールド」の形で値へアクセス出来ます。javaでいう拡張for文のようなイメージです。
今回だと、`th:each="lesson : ${lessonList}"`でlessonListの値を取り出し変数`lesson`に代入し、表の表示に必要な値を1つずつ取り出し、表示しています。
* Thymeleaf(タイムリーフ) の構文については以下を参照してください。  
[参考資料：Thymeleafの紹介](https://www.thymeleaf.org/doc/tutorials/3.0/usingthymeleaf_ja.html#thymeleaf%E3%81%AE%E7%B4%B9%E4%BB%8B)

# データベースの利用について(H2 Database)
既存プログラムでは、データベースとして「H2 Database」が利用されています。  
Javaプラットフォーム上で動くオープンソースのRDBMSです。  
非常に軽量なデータベースのため、Javaプログラミングを試したりテストしたい場合によく利用されます。  
データの保存先はインメモリかファイルです。  
既存プログラムでは、保存先をメモリと指定しています。  
そのため、起動し直す度にデータは削除されますので注意してください。  

起動の度に、以下2つのファイル内のSQL文が実行されます。  
* `~\portal\src\main\resources\schema.sql`
* `~\portal\src\main\resources\data.sql`  
schema.sqlには、CREATE TABLE文などのDDL文を、data.sqlには、INSERT文などのDML文を記載します。  
テーブル定義を変えたい、初期データに何か手を加えたい時は上記2ファイルを変更してください。  

# 補足
## 各コードの配置場所について
* Controllerクラス  
`/workspaces/portal/src/main/java/com/classroom/assignment/controller`  
* Serviceクラス  
`/workspaces/portal/src/main/java/com/classroom/assignment/service`  
* Daoクラス  
`/workspaces/portal/src/main/java/com/classroom/assignment/repository`  
* ビュー(テンプレート)  
`/workspaces/portal/src/main/resources/templates`  

左側ツリーから参照してください。  
![image](https://user-images.githubusercontent.com/32722128/194747137-ba2da33b-5ea3-4f98-b51b-501c2f074807.png)
