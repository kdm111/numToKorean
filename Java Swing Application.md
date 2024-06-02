## Java Swing Application



### Java Swing Application

Java Swing은 프로그래밍 언어를 사용하여 GUI를 개발하는데 도와주는 라이브러리.



### 컴포넌트 Hierarchy

1. JFrame : 최상위 컴포넌트로 다른 컴포넌트가 이 안에 위치한다.
2. JDialog : 모달 또는 모달리스 대화상자를 나타내는 컴포넌트
3. JApplet : 웹 브라우저에서 실행되는 애플릿을 표현하는 컴포넌트
4. JInternalFrame : 내부 프레임을 나타내는 컴포넌트
5. JDesktopPane : 내부 프레임을 담는 컨테이너 컴포넌트
6. JPanel : 다른 컴포넌트를 그룹화하거나 배치할 수 있는 패널 컴포넌트
7. JComponent : 모든 Swing 컴포넌트의 슈퍼클래스로 커스텀 컴포넌트를 만들 때 사용됨.
8. JButton, JCheckBox, JRadioButton : 사용자가 상호 작용할 수 있는 버튼 컴포넌트
9. JList, JTable, JTree : 데이터를 표시하거나 선택할 수 있는 리스트, 테이블, 트리 컴포넌트
10. JLabel : 텍스트나 이미지를 표시하는 레이블 컴포넌트
11. JTextField, JTextArea : 텍스트 입력을 받는 텍스트필드, 텍스트 영역 컴포넌트

```
JFrame
	>ContentPane(JPanel)
		> JSCrollPane(Optional)
			> JPanel, JList, JTable
		> JButton
		> JLabel
		> JTextField
		> JComboBox
		> JCheckBox
		> JRadioButton
		> JMenu
			> JMenuItem
		> JToolBar
			> JButton
		> JProgressBar
		> JSlider
		> JTree
		> JSeparator
```



### 자주 사용하는 컴포넌트

* JButton : 클릭 이벤트를 처리하는 버튼 컴포넌트
* JLabel : 텍스트나 이미지를 표시하는 레이블 컴포넌트
* JTextField : 사용자로부터 텍스트 입력을 받는 텍스트 필드 컴포넌트
* JTextArea : 여러 줄의 텍스트 입력을 받는 텍스트 영역 컴포넌트
* JComboBox : 드롭다운 목록 형태의 선택 상자 컴포넌트
* JCheckBox : 사용자가 선택할 수 있는 체크박스 컴포넌트
* JRadioButton : 여러 옵션 중 하나를 선택할 수 있는 라디오 버튼 컴포넌트
* JTable : 표 형태로 데이터를 표시하고 편집할 수 있는 테이블 컴포넌트
* JList : 리스트 형태로 데이터를 표시하고 선택할 수 있는 리스트 컴포넌트
* JScrollPane : 스크롤 가능한 컨텐츠를 제공하는 스크롤 패널 컴포넌트



### JFrame

프로그램의 메인 윈도우를 나타낸다.

1. `JFrame`은 운영 체제의 네이티브 윈도우를 나타내며, 제목 표시줄, 메뉴 바, 경계선, 최소,최대,닫기 버튼을 포함한다.
2. `JFrame`은 다른 Swing 컴포넌트를 담을 수 있는 컨테이너 역할을 한다. `JPanel`, `JButton`, `JLabel` 등의 컴포넌트를 `JFrame`에 추가할 수 있다.
3. `JFrame`은 기본적으로 `BorderLayout` 레이아웃 관리자를 사용하지만 다른 레이아웃 관리자로 변경할 수 있다.
4. `JFrame`은 윈도우 이벤트(창 열기, 닫기, 최소화)를 처리할 수 있다.
5. `setVisible(true)` 메서드를 호출하면 화면에 프레임이 표시된다.



### Layout

레이아웃 관리자(Layout Manager)는 Java Swing에서 컨테이너 안에 포함된 컴포넌트들의 배치와 크기를 자동으로 조절한다. 개발자가 직접 컴포넌트의 위치와 크기를 지정하지 않아도 GUI 디자인 작업이 편리해진다.

#### FlowLayout

컴포넌트들을 왼쪽에서 오른쪽으로 차례대로 배치한다. 한 줄에 모든 컴포넌트를 배치할 수 없으면 다음 줄로 넘어간다.

컨테이너 크기에 따라 자동으로 줄바꿈이 된다.

#### BorderLayout

컨테이너를 5개의 영역 (n,s,e,w,c)로 나눠 각 영역에 하나의 컴포넌트만을 배치할 수 있다.

주로 메인 프레임의 기본 레이아웃으로 사용된다.

#### GridLayout

컨테이너를 격자 모양의 동일한 크기의 셀로 나누고 컴포넌트를 배치한다.

모든 셀의 크기가 동일하다.

#### CardLayout

컨테이너 내에서 한 번에 하나의 컴포넌트만 보이게하고 다른 컴포넌트는 숨깁니다. 탭 패널 등에 사용된다.

사용자 인터페이스에서 여러 화면을 전환할 때 유용하다.

#### GridBagLayout

컨테이너를 격자 모양의 셀로 나누고 각 셀에 하나 이상의 컴포넌트를 배치할 수 있다.

셀의 크기와 위치를 유연하게 조절할 수 있어 가장 복잡한 레이아웃이다.

#### BoxLayout

컴포넌트들을 가로 또는 세로 방향으로 연속적으로 배치한다.



### JPanel

가장 기본적인 컨테이너 클래스 중 하나이다. `JPanel`은 다른 컴포넌트들을 그룹화 하거나 레이아웃을 관리하기 위해 사용된다.

`Container` 클래스를 구현하고 있어 다른 컴포넌트를 포함하거나 레이아웃을 설정하여 그 컴포넌트들의 배치를 조절할 수 있다.

* `JPanel`을 사용하여 관련있는 여러 컴포넌트들을 하나의 그룹으로 묶어서 관리할 수 있다.

* 레이아웃관리자를 사용할 수 잇다. `FlowLayout`,`BorderLayout`, `GridLayout` 컴포넌트 배치를 조절할 수 있다. 각 레이아웃은 컴포넌트를 배치하는 방식에 차이가 있고 개발자의 필요에 따라 선택적으로 사용할 수 있다.

* 배경색이나 투명도를 조절할 수 있다. 이를 통해 GUI의 시각 효과를 개선할 수 있다.

* 이벤트를 직접 처리할 수 있고 내부에 다른 컴포넌트가 이벤트를 발생시키면 이벤트를 받아 처리할 수 있다.



