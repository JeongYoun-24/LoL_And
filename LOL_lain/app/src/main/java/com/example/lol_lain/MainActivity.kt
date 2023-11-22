package com.example.lol_lain

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.GravityCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.lol_lain.databinding.ActivityMainBinding

import com.example.lol_lain.adpter.ProfileAdapter
import com.example.lol_lain.data.Profiles
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    //   private lateinit var recyclerView: RecyclerView
    //  private lateinit var viewAdapter: RecyclerView.Adapter<*>
    // private lateinit var viewManager:RecyclerView.LayoutManager
    // private var myDataset = listOf("1.사과","2.배","3.오렌지")




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val intent4 = Intent(this, LoLActivity::class.java)
        binding.SumBtn.setOnClickListener{startActivity(intent4)}


        // 라이엇 url api 에서 이미지 받아오기
        val Imgurl = "https://raw.communitydragon.org/latest/plugins/rcp-fe-lol-parties/global/default/button-search-hover.png"
        Glide.with(this).load(Imgurl).placeholder(R.drawable.frame).error(R.drawable.error).into(binding.seletImg)

        val profileList = arrayListOf(  // 리사이클뷰 더비 데이터
            // 1번째 줄
            Profiles(R.drawable.ga,"가렌","Garen","전사","가렌은 불굴의 선봉대를 이끄는 고결하고 자긍심 강한 전사다. 선봉대 내에서 인망이 두터울 뿐 아니라 심지어 적에게도 존경을 받지만, 그가 대대로 데마시아와 데마시아의 이상을 수호하는 임무를 맡은 크라운가드 가문의 자손이기 때문은 아니다. 가렌은 마법 저항력을 갖춘 방어구와 거대한 대검으로 무장하고, 언제라도 마법사에 맞서 정당한 검으로 진정한 칼바람을 일으킬 준비가 되어 있다."),
            Profiles(R.drawable.gal,"갈리오","Galio","탱커","아스라한 빛의 도시 데마시아의 성문 밖, 거대한 석상 갈리오가 경계의 눈을 늦추지 않고 서 있다. 마법사의 공격으로부터 데마시아를 수호하기 위해 만들어진 갈리오는 강력한 마법의 힘이 그를 깨울 때까지 수십 년, 때로는 수백 년 동안 한자리에 미동도 없이 서있다. 일단 깨어나면 전투의 아찔한 스릴과 데마시아인들을 구한다는 자부심을 음미하며 1분 1초도 허투루 쓰는 법이 없다. 그러나 그가 쟁취한 승리의 향기는 결코 달콤하지만은 않다. 아이러니하게도 그가 물리친 마법의 힘이 그에게 생명을 준 원천이기에 전쟁을 승리로 장식한 후에는 다시 깊은 잠으로 빠져든다."),
            Profiles(R.drawable.geng,"갱플랭크","Gangplank","전사","몰락한 해적왕 갱플랭크는 잔인한 성격에다 종잡을 수 없으며 사악함은 타의 추종을 불허한다. 과거 항구도시 빌지워터를 힘으로 장악했으나 지금은 영향력을 잃었다. 하지만 사람들은 그렇기 때문에 오히려 갱플랭크가 더 미쳐 날뛰리라고 생각한다. 갱플랭크는 빌지워터를 다른 사람에게 넘기느니 다시 한 번 피바다로 만들어 버릴 인물이니까. 그리고 이제, 권총, 해적검, 화약통으로 무장한 갱플랭크가 잃었던 패권을 되찾기 위한 준비를 끝냈다."),
            Profiles(R.drawable.ge,"그라가스","Gragas","전사","그라가스는 몸집이 크고 소란스러워서 한 번 보면 잊기 힘든 쾌활한 주조가로, 완벽한 술을 만들기 위한 여정을 떠나게 되었다. 그라가스가 어디서 왔는지는 아무도 모르지만, 프렐요드의 때묻지 않은 불모지를 뒤지며 희귀한 재료를 찾아 주조법을 하나씩 시험해 보고 있다. 대부분 술에 취해 있어 극도로 충동적인 그라가스는 소동을 일으키는 데에는 전설적인 소질이 있는데, 그 소동은 밤샘 파티와 엄청난 기물 파손으로 이어지기 일쑤다. 그라가스를 보게 된다면 곧 음주, 그리고 파괴가 잇따를 것이라고 생각해도 좋다."),
            Profiles(R.drawable.gere,"그레이브즈","Graves","원거리딜러","말콤 그레이브즈는 명성이 자자한 용병, 도박사, 도적으로, 그가 한 번이라도 발을 들였던 모든 도시와 제국에서 수배령이 떨어져 있을 정도다. 그레이브즈는 성미가 불 같지만, 범죄의 명예에 엄격한 면이 있어 자신의 이중 총열 산탄총 '운명'으로 마무리를 하는 경우가 잦다. 최근에는 트위스티드 페이트와 함께 바람 잘 날 없던 파트너 관계를 다시 맺고, 범죄의 냄새가 나는 빌지워터의 그늘진 곳에서 벌어지는 소동을 다시 한 번 주름잡고 있다."),
        )
        val profileList2 = arrayListOf(  // 리사이클뷰 더비 데이터
            // 2번째 줄
            Profiles(R.drawable.gwen,"그웬","Gwen","전사","마법의 힘으로 살아나 인간이 된 인형 그웬은 한때 자신을 만들었던 도구를 휘두른다. 발걸음을 내디딜 때마다 자신을 만든 창조자의 사랑을 느끼며 모든 것을 감사히 여긴다. 그웬이 부리는 신성한 안개는 그웬의 가위와 바늘, 실에 축복을 내린 고대의 보호 마법이다. 모든 게 새로운 것으로 가득하지만, 그웬은 망가진 세상에서 살아남은 선한 이들을 위해 기꺼이 싸우러 나선다."),
            Profiles(R.drawable.naleu,"나르","Gnar","전사","고대 요들인 나르는 익살스러운 장난을 치다가도 어린아이 같은 변덕을 부려 벌컥 화를 내며, 그럴 때면 순식간에 거대한 몸집의 야수로 변하여 주변을 마구 때려부순다. 수천 년 동안이나 얼음 정수에 갇혀 있다가 풀려난 터라, 지금의 세계는 나르에게 진기하고 경이로운 세상이다. 호기심 많은 나르는 위험이 닥치면 오히려 즐거워하며, 뼈이빨 부메랑이든 옆에 서 있는 건물이든 닥치는 대로 집어들어 적에게 던진다."),
            Profiles(R.drawable.nami,"나미","Nami","서포터","나미는 바다에 사는 바스타야 종족으로, 어리지만 완고할 정도로 고집이 세다. 먼 옛날 타곤 인과 맺었던 약속이 깨지자, 마라이 종족으로는 처음으로 파도 치는 바다에서 나와 마른 육지로 모험을 떠났다. 달리 해결책이 없었기에, 자신의 종족을 안전하게 지켜주는 성스러운 의식을 완수한다는 임무를 자청한 것이었다. 새로운 시대는 혼란 그 자체지만, 나미는 용기와 결단력으로 불확실한 미래를 마주한다. 그녀의 무기는 바다의 힘을 소환하는 파도 소환사의 지팡이다."),
            Profiles(R.drawable.naseoseu,"나서스","Nasus","전사","자칼의 머리를 한 위풍당당한 반인반수 형상의 초월체 나서스는 고대 슈리마의 영웅적인 인물이었다. 날카로운 지력을 소유한 그는 지식의 수호자이자 최고의 전략가로서 수세기 동안 슈리마 제국을 번영으로 인도했다. 제국의 몰락 이후엔 칩거에 들어가 전설 속의 존재가 되었다. 하지만 슈리마의 고대 도시가 되살아나면서, 제국의 몰락이 다시는 일어나지 않도록 하겠다는 다짐과 함께 세상 밖으로 나왔다."),
            Profiles(R.drawable.napili,"나파리","","암살","오늘도 슈리마 사막에는 우렁찬 포효가 합창곡처럼 울려 퍼진다. 이는 게걸스러운 포식자의 무리, 모래 언덕의 사냥개들이 울부짖는 소리다. 이 황량한 땅에서 사냥 경쟁은 계속되고 있다. 그중 정점에 오른 무리가 있다. 사냥개의 본능이 아니라, 고대 다르킨의 힘을 품고 움직이는 무리 말이다."),
        )
        val profileList3 = arrayListOf(  // 리사이클뷰 더비 데이터
            // 3번째 줄
            Profiles(R.drawable.notilleoseu,"노틸러스","Nautilus","탱커","빌지워터에는 처음으로 물에 잠긴 부두만큼이나 오래되었다는 쓸쓸한 전설이 하나 있다. 육중한 갑옷을 걸친 노틸러스라는 이름의 거인이 푸른 불꽃 제도 해안가의 검푸른 물을 배회한다는 이야기이다. 이제는 기억나지도 않을 복수심에 사로잡힌 그는 예고도 없이 거대한 닻을 휘둘러 가여운 자들을 구하고 탐욕스러운 자들을 죽음으로 인도한다. '빌지워터의 공물'이라는 절대 어겨선 안 될 약속을 잊은 자들을 바닷속으로 끌고 들어가며, 끌려들어 간 자는 누구도 그곳에서 살아 돌아올 수 없다고 한다."),
            Profiles(R.drawable.nogteon,"녹턴","Nocturne","암살자","언제부터인가 자의식이 있는 존재라면 반드시 꾸는 악몽이 있었다. 그리고 그 악몽들이 모여 사악한 기운을 끌어들였고, 그 속에서 태곳적 힘을 지닌 순수한 악 그 자체인 녹턴이 생겨났다. 녹턴은 혼돈을 암흑의 액체로 표현한 듯한 형상으로, 얼굴은 없으나 차디찬 눈을 지녔으며 흉흉해 보이는 칼날로 무장했다. 영혼계에서 탈출하여 생명이 깨어 있는 세계로 내려온 녹턴은 진정한 암흑에서나 피어날 법한 공포를 먹이로 삼는다."),
            Profiles(R.drawable.nunu,"누누와월럼프","Nunu","탱커","아주 오랜 옛날, 무시무시한 괴물을 물리쳐 영웅이 되고 싶은 소년이 있었다. 하지만 소년이 발견한 것은 마법을 부리는, 단지 친구가 필요했던 외로운 설인이었다. 고대의 힘과 눈싸움으로 하나가 된 소년 누누와 설인 윌럼프는 프렐요드 곳곳을 누비며 상상 속의 모험을 떠난다. 실종된 누누의 어머니를 찾아 나선 누누와 윌럼프. 이들이 누누의 어머니를 구한다면 영웅이 될 수 있을지도..."),
            Profiles(R.drawable.nidalli,"니달리","Nidalee","암살자","깊은 정글에서 자라난 니달리는 자신의 형태를 흉포한 쿠거로 자유자재로 변화시킬 수 있는 추적의 달인이다. 완전한 여인도, 완전한 야수도 아닌 니달리는 신중하게 배치한 덫과 재빠른 창 투척으로 모든 침입자들로부터 자신의 영역을 맹렬하게 지켜낸다. 니달리는 사냥감을 움직이지 못하게 공격한 후 쿠거 형태로 변해 덮친다. 니달리에게서 운 좋게 살아남은 몇 사람은 야생에 사는 여자가 있다는 이야기를 퍼뜨렸다. 본능이 극도로 예리하고, 발톱은 그보다도 더 예리하다고..."),
            Profiles(R.drawable.niko,"니코","Neeko","마법사","오랜 세월 잊힌 바스타야의 한 부족 출신인 니코는 다른 이의 모습을 빌려 어느 무리에든 뒤섞일 수 있으며, 심지어 상대의 감정을 흡수하여 적과 아군을 한눈에 구분할 수 있다. 그 누구도 니코가 어디 있는지, 정체가 무엇인지 확신할 수 없지만, 악의를 가지고 접근하는 자는 원초적 영혼 마법의 무시무시한 힘과 함께 그녀의 진정한 모습을 보게 될 것이다.")
        )
        val profileList4 = arrayListOf(  // 리사이클뷰 더비 데이터
            // 4번째 줄
            Profiles(R.drawable.nilra,"닐라","","원거리딜러","멀리 떨어진 땅에서 온 고행의 전사, 닐라는 세계에서 가장 위협적이고 거대한 상대를 찾아 도전하고 파괴한다. 오랫동안 갇혀 있던 기쁨의 악마를 만나 힘을 얻은 그녀에게 멈추지 않는 기쁨 외에 다른 감정은 없다. 자신의 막강한 힘을 위한 사소한 대가인 셈이다. 악마의 물을 막강한 힘을 지닌 칼날로 바꾼 닐라는 오래전에 잊힌 고대의 위협에 맞서 싸운다."),
            Profiles(R.drawable.darius,"다리우스","Darius","전사","녹서스 그 자체를 상징하는 인물로 다리우스만큼 어울리는 사람도 없을 것이다. 실전에서 단련된 사령관이자 녹서스 내에서조차도 두려움의 대상이니까. 다리우스는 미천한 집안에서 태어났으나 녹서스 제국의 적들을 파죽지세로 베어넘기면서 트리파르 군단 사령관이라는 지금의 자리와 권력을 획득했다. 문제는 그 적들 다수가 녹서스 인이었다는 사실이다. 다리우스는 자신의 명분이 정당하다는 것을 한 번도 의심한 적이 없으며, 도끼를 치켜들 때에도 망설임이 없다. 그러니... 더 보기"),
            Profiles(R.drawable.daiaena,"다이애나","Diana","마법사","다이애나는 오늘날 거의 사멸된 고대 종교 '루나리'의 전사이자, 은빛 달의 화신 그 자체다. 그녀는 드높은 타곤 산 꼭대기에 떠오른 천체들의 기운을 온몸으로 받아들였고, 겨울 밤 설원처럼 은은하게 빛나는 갑옷과 초승달 검으로 무장했다. 그러나 인간을 초월한 그녀의 힘이 무엇을 위한 것인지는 아직까지 분명하지 않다. 다이애나는 이 세상에서 자신에게 부여된 사명이 무엇인지 알아내려 애쓰고 있다."),
            Profiles(R.drawable.draven,"드레이븐","Draven","원거리딜러","녹서스에서는 경기장에서 피를 흘리며 싸우고 힘을 겨루는 전사들이 있다. 검투사로 알려진 이들 중 드레이븐만큼 많은 환호를 받은 전사는 없었다. 전직 군인인 드레이븐은 극적으로 회전 도끼를 던지는 화려하고 독보적인 기술에 관중들이 환호한다는 것을 알아차렸다. 드레이븐은 요란하고도 완벽한 구경거리를 만들어내는 자신의 기술에 도취되어, 드레이븐이라는 이름을 녹서스 제국에 길이 남기기 위해 누구든 쓰러뜨리겠다고 다짐했다."),
            Profiles(R.drawable.rise,"라이즈","Ryze","마법사","룬테라의 최고 마법사로 널리 알려진 라이즈는 산전수전을 겪으며 중차대한 임무를 수행하는 고대의 대마법사다. 가공할 마력과 무한한 체력을 보유한 그는, 태초에 무에서 세계를 창조한 원초적 마법의 파편인 룬을 찾기 위해 쉴 틈 없이 이곳저곳을 떠돌고 있다. 룬이 룬테라에 어떤 참사를 일으킬 수 있는지 알고 있기에 라이즈는 룬이 잘못된 손에 들어가지 않도록 빠짐없이 찾아야만 한다.")
        )
        val profileList5 = arrayListOf(  // 리사이클뷰 더비 데이터
            // 5번째 줄
            Profiles(R.drawable.rakan,"라칸","Rakan","서포터","활달하고 변덕스러우면서도 거부하기 힘든 매혹을 발산하는 라칸은 악명 높은 바스타야 말썽꾼이자 로틀란 부족 역사상 가장 훌륭한 전장의 춤꾼이다. 아이오니아 고원 지대에 사는 사람들에게 라칸이라는 이름은 꽤 오래 전부터 시끌벅적한 축제, 흥이 넘치는 파티, 기존의 규칙을 거부하는 음악과 동일시되고 있다. 하지만 타고난 춤꾼이자 활력 넘치는 방랑자인 라칸이 저항 운동을 하는 자야와 동반자 관계가 되었으며, 자야의 대의에 헌신하고 있다는 사실을 아는 사람은 극히 드물다."),
            Profiles(R.drawable.remmus,"람머스","Rammus","탱커","알 수 없는 신비의 존재 람머스. 누군가에게는 숭배의 대상이고, 또 누군가에게는 경외의 대상인 우상과도 같은 인물. 더러는 우리와 똑같은 인간으로 여겨지는 경우도 있다. 하지만 한 가지 분명한 것은 그 누구도 람머스의 정체를 제대로 알지 못한다는 것. 베일에 가려진 수수께끼의 존재라는 사실이다. 뾰족한 못이 박힌 갑옷을 입고 다니는 그를 두고 사람들은 여러가지 추측을 내놓는다. 반신반인의 존재라느니, 신성한 사제라느니, 마술에 걸린 야수일 뿐이라는 얘기까지 무척이나 다양하다. 그러나 진실이 무엇이든, 사막을 배회하며 뭐든지 제 생각대로 해버리고 마는 람머스의 의지를 꺾을 자는 아무도 없다."),
            Profiles(R.drawable.lux,"럭스","Lux","마법사","럭산나 크라운가드는 데마시아 인으로, 마법 능력을 가진 자를 공포와 의심을 담은 편협한 시선으로 보는 환경에서 태어났다. 고귀한 가문의 딸이지만 빛을 자유자재로 다루는 마법력을 타고났기에 이 능력이 발각되면 추방당할 것이라는 두려움을 안고 어린 시절을 보냈다. 자신의 능력을 감추는 것만이 가문의 명예를 지키는 방법이라고 여겼지만, 낙천적이고 유연한 성격 덕분에 차츰 자신만의 재능을 인정하고 받아들였고, 이제는 조국을 위해 마법을 은밀하게 사용하고 있다."),
            Profiles(R.drawable.rumble,"럼블","Rumble","마법사","럼블은 한 성깔 하는 젊은 요들로, 탁월한 발명가이기도 하다. 두 손과 고철 더미만으로 전기 작살과 소이 로켓을 장착한 거대 기계 로봇을 뚝딱 만들어냈다. 고철부품으로 만든 럼블의 작품을 비웃고 조롱하는 자가 있더라도 럼블은 눈 하나 깜박하지 않는다. 어차피 전장을 휩쓸 화염방사기는 자신의 손에 있으니까."),
            Profiles(R.drawable.renata,"레나타 글라스크","Renata","서포터","레나타 글라스크는 어린 시절 집의 잿더미를 딛고 일어섰다. 그때 레나타가 가진 것은 이름과 부모님의 연금술 연구 자료뿐이었다. 수십 년이 지나, 레나타는 자운에서 가장 부유한 화공 남작 겸 거물 사업가가 되었다. 그녀는 모든 사람의 이해관계를 자신과 묶어서 막대한 힘을 쌓았다. 레나타와 함께하는 자는 상상 이상의 보상을 받는다. 레나타를 거스르는 자는 그 선택을 후회하며 살아간다. 하지만 결국에는 모두가 그녀의 편에 설 것이다.")
        )
        val profileList6 = arrayListOf(  // 리사이클뷰 더비 데이터
            // 6번째 줄
            Profiles(R.drawable.renekton,"레넥톤","Renekton","전사","불길에 그을린 슈리마 사막에서 다시 일어선 무시무시한 분노의 초월체, 레넥톤. 한 때 그는 슈리마 최고의 전사로서 무수한 전쟁을 승리로 이끌었다. 하지만 슈리마의 몰락과 함께 사막 아래 무덤 속에 갇혔고, 강산이 변하는 억겁의 세월을 어둠 속에서 보내면서 서서히 광기에 굴복해 갔다. 다시 자유의 몸이 된 레넥톤이 원하는 것은 단 하나, 자신을 가둔 형에 대한 복수뿐이다."),
            Profiles(R.drawable.leona,"레오나","Leona","서포터","솔라리 성전사 레오나는 천공의 검과 여명의 방패로 타곤 산을 수호한다. 레오나의 몸은 태양의 불길로 가득하며, 피부는 별의 광채로 빛나고, 눈동자는 천체들의 기운으로 불타오른다. 황금 갑주와 어마어마한 고대의 지식으로 무장한 레오나는 어떤 이들에게는 깨우침을, 어떤 이들에게는 죽음을 선사한다."),
            Profiles(R.drawable.reksai,"렉사이","RekSai","암살자","최상위 포식자 렉사이는 무자비한 공허 태생 생명체로, 땅굴을 파고 들어가 있다가 방심한 먹잇감을 덮쳐 게걸스럽게 집어삼킨다. 렉사이의 그칠 줄 모르는 식탐 때문에 위대한 슈리마 제국 전체가 초토화되었을 정도다. 사막을 오가는 상인이나 여행자들은 아무리 철저하게 무장을 했더라도 렉사이의 영토를 피하려고 일부러 멀고 먼 길을 돌아가곤 한다. 렉사이가 지평선에 보이면, 지하에서 기다리고 있는 것은 죽음 뿐이라는 것을 모르는 사람은 없다."),
            Profiles(R.drawable.rel,"렐","Rell","탱커","검은 장미단의 악랄한 실험으로 탄생한 렐은 녹서스의 전복만을 위해 달리는 생체 무기이다. 금속을 조종하는 능력 때문에 그녀는 고통과 공포로 점철된 어린 시절을 보내며 끔찍한 전투 훈련을 받아야 했다. 견디다 못한 나머지 자신을 구속한 자들을 죽이고 도망쳤고, 결국 범죄자로 낙인찍혔다. 자유의 몸이 된 렐은 이제 자신과 같은 고통을 겪던 아이들을 구출하며 녹서스 병사들을 보이는 대로 처치한다. 그리고 과거의 스승들에게는 무자비한 죽음을 안겨 주고, 약자들은 보호한다."),
            Profiles(R.drawable.renger,"렝가","Rengar","암살자","포악한 기질의 렝가는 바스타야 종족으로, 난폭하고 사나운 생명체를 추적하고 처치하는 순간의 짜릿한 전율을 삶의 낙으로 여기는 전리품 수집가다. 그는 강하고 무시무시한 괴물을 사냥하기 위해 온 세상을 샅샅이 뒤진다. 그중에서도 그가 가장 찾고자 하는 사냥감은 그의 한쪽 눈을 앗아간 공허의 약탈자 카직스다. 렝가가 사냥을 하는 이유는 굶주린 배를 채우기 위함도, 영광을 누리기 위함도 아니다. 그는 사냥 그 자체의 즐거움을 만끽하기 위해 오늘도 먹잇감을 찾아 나선다.")
        )
        val profileList7 = arrayListOf(  // 리사이클뷰 더비 데이터
            // 7번째 줄
            Profiles(R.drawable.lucian,"루시안","Lucian","원거리딜러","빛의 감시자 루시안은 고대의 마력이 깃든 한 쌍의 총으로 무장하고 언데드를 추격해 몰살하는 죽음의 사냥꾼이다. 악령 쓰레쉬가 그의 아내를 살해한 후 루시안은 복수의 여정을 떠났지만 그녀가 살아 돌아왔음에도 그의 분노는 사그라지지 않았다. 오직 한 가지 목표만을 쫓는 무자비한 루시안은 검은 안개의 고대 망령들로부터 산 자들을 지키기 위해서라면 어떤 일도 서슴지 않을 것이다."),
            Profiles(R.drawable.lulu,"룰루","Lulu","서포터","요들 마법사 룰루는 친구인 요정 픽스와 함께 룬테라를 돌아다니며, 꿈결같은 환상과 상상 속에서나 존재할 법한 생명체를 만들어내는 것으로 유명하다. 룰루는 내키는 대로 현실을 빚어내고, 세상의 법칙을 비틀어 버린다. 룰루가 보기에 이 세상의 물리 법칙에 따르는 제약은 시시하고 따분하다. 룰루의 마법은 좋게 본다 해도 비정상적이고 나쁘게 보면 위험하다고까지 할 수도 있겠지만, 룰루의 신념은 확고하다. 사람들에게 마법 한 번씩 맛보여 주는 게 뭐 그리 큰일이냐는 것이다."),
            Profiles(R.drawable.leblanc,"르블랑","Leblanc","마법사","르블랑은 검은 장미단의 다른 구성원들조차도 본모습을 알지 못하는 신비로운 존재다. 사실 르블랑이라는 이름은 녹서스 건국 초기부터 사람들과 사건을 마음대로 홀리고 조작하던, 안색이 창백한 어느 여인이 갖고 있던 수많은 이름 중 하나에 불과하다. 르블랑은 마법으로 자신의 형체를 복제할 수 있으므로 누구에게든, 어디에든 모습을 드러낼 수 있으며 심지어 여러 장소에 동시에 존재할 수도 있다. 좀체로 남의 눈에 띄지 않고 진짜 정체를 아는 사람도 없기에, 르블랑의 진정한 동기 역시 비밀에 싸여 있다."),
            Profiles(R.drawable.leesin,"리신","","전사","리 신은 아이오니아에 전해 내려오는 고대 무술에 통달했다. 지조 높고 고결한 전사로, 싸워야 할 때에는 용의 혼의 정수를 끌어낸다. 오래 전에 시각을 잃었으나, 고향 땅의 신성한 균형을 해치려 드는 자를 막아내는 데 일생을 바치겠다는 신념은 흔들림이 없다. 명상에 잠긴 듯 고요한 태도를 얕보고 함부로 덤벼드는 적은 리 신의 불꽃 같은 주먹과 초인적 위력의 돌려차기에 속수무책으로 당한다."),
            Profiles(R.drawable.ribbon,"리븐","Riven","전사","한때 녹서스 군의 소드마스터였던 리븐은 그녀가 정복하려던 땅에서 추방자로 살아가고 있다. 그녀는 확고한 믿음과 잔혹함에 가까운 능력에 힘입어 상급 군인으로 진급하고 전설의 룬 검과 군대를 포상으로 받았다. 그러나 녹서스에 대한 리븐의 믿음은 아이오니아 전선에서 시험대에 올랐고 결국 산산히 깨지고 말았다. 제국과의 모든 연결고리를 끊어버린 그녀는 산산이 조각난 세상 속 몸을 맡길 곳을 찾아 방랑하고 있다. 녹서스 제국이 재건되었다는 무성한 소문에도 불구하고...")
        )
        val profileList8 = arrayListOf(  // 리사이클뷰 더비 데이터
            // 8번째 줄
            Profiles(R.drawable.lisandra,"리산드라","Lissandra","마법사","혹한의 북쪽 땅 주민들은 아주 먼 옛날부터 '그녀'를 두려워했다. 그녀는 순수한 냉기를 왜곡시켜 어둠의 힘으로 부리는 마법을 구사했으며, 날카로운 얼음으로 자신에 대적하는 적들을 모조리 꿰뚫어 버리거나 으스러뜨렸다. 얼마나 무시무시하고 막강한 힘이었는지! 사람들은 그녀의 본명을 언급하는 것마저 꺼려 '얼음 마녀'라는 별명으로 그녀를 칭하곤 했다. 그러나 진정 두려운 것은 그녀의 힘이 아니라 위험한 계획이었다. 이 사악한 마녀의 이름은 리산드라, 그녀는 대자연을 암흑의 힘으로 물들여 이 세계에 빙하기를 초래하려 한다."),
            Profiles(R.drawable.ililia,"릴리아","Lillia","마법사","부끄럼을 많이 타는 사슴, 릴리아는 조심스럽게 아이오니아의 숲을 배회한다. 필멸자들의 모습에 매료되면서도, 동시에 공포를 느끼는 그녀는 꿈꾸는 나무에 인간들의 꿈이 흘러들지 않는 이유를 궁금해한다. 이제 릴리아는 마법이 깃든 나뭇가지를 손에 쥐고 아이오니아를 여행한다. 이뤄지지 못한 인간들의 꿈을 찾고, 그들의 빛을 가리고 있는 공포를 없애야만 릴리아 역시 활짝 피어날 수 있기 때문이다."),
            Profiles(R.drawable.mrlee,"마스터 이","MasterYi","암살자","마스터 이는 수련을 통해 심신을 갈고 닦아, 마침내 생각과 행동이 일치하는 경지에 이르렀다. 최후의 수단으로 무력을 사용할 것을 결심하기는 했지만, 마스터 이는 품위 있고 빠른 검 놀림으로 자신의 결단을 언제나 빠르게 수행했다. 아이오니아의 우주류 검술의 살아있는 마지막 전승자인 마스터 이는 자신의 '통찰의 칠안경'과 함께 제자가 되려는 후보자 중 가장 적합한 자를 꼼꼼히 조사하는 등 고향의 유산을 이어가는 데에 일생을 바친다."),
            Profiles(R.drawable.maokai,"마오카이","Maokai","탱커","거대한 나무 정령 마오카이는 분노에 휩싸여 그림자 군도의 초자연적인 언데드와 싸운다. 마법에 의한 대격변으로 고향이 파괴되었을 때 그는 자신의 나무 심장에 스며 있는 생명의 정수로 언데드의 상태는 모면했지만 형체가 뒤틀린 복수의 화신이 되었다. 한 때는 평화를 사랑하는 자연의 정령이었으나 이제 그는 그림자 군도를 뒤덮은 언데드를 몰아내고 아름답던 고향의 옛 모습을 되찾기 위해 맹렬하게 싸운다."),
            Profiles(R.drawable.malzaha,"말자하","Malzahar","마법사","말자하는 모든 생명체를 하나로 결합시키겠다는 사명에 전심전력을 바치는 예언자다. 그는 근래 룬테라를 덮치기 시작한 공허야말로 룬테라를 구원하는 길이라고 진심으로 믿고 있다. 모래 가득한 슈리마의 황무지에서, 말자하는 머릿속에서 울리는 속삭임이 이끄는 대로 따라간 끝에 이케시아에 다다랐다. 이제는 폐허가 되어버린 이케시아 한가운데에서 그는 공허의 어두운 심장부를 들여다보았고, 새로운 힘과 목적을 부여받았다. 이제 말자하는 자신을 목자로 칭한다. 그에게 주어진 힘으로 인간을 공허라는 우리 안으로 인도할 수도 있고, 아니면 땅밑에서 우글거리는 공허충을 이 세계에 풀어놓을 수도 있기에.")
        )


        val profileList9 = arrayListOf(  // 리사이클뷰 더비 데이터
            // 9번째 줄
            Profiles(R.drawable.malphite,"말파이트","Malphite","탱커","암석으로 이루어진 거대한 자연물 말파이트는 혼란스러운 세상에 평화로운 질서를 가져오기 위해 노력하고 있다. 말파이트는 원래 다른 세계에서 '거석'이라 불리는 돌기둥의 일부이자 거석을 지키는 파수꾼으로 태어났으며, 막강한 자연의 힘으로 거석을 보호하려 했으나 실패하고 말았다. 거석이 파괴된 후, 유일하게 살아남은 말파이트는 이제 룬테라의 물렁물렁한 생명체와 그들의 변덕스러운 성미를 참아내며 마지막 생존자에게 어울리는 새로운 임무를 찾고 있다."),
            Profiles(R.drawable.mordekaiser,"모데카이저","Mordekaiser","마법사","이미 두 번이나 죽었지만 세 번째로 되살아난 모데카이저는 옛 시대의 잔혹한 군주로서 강령술을 사용해 영혼들을 영원한 노예로 만듭니다. 지금은 그의 정복 활동을 기억하거나, 그의 진정한 힘을 아는 이는 거의 없습니다. 하지만 모데카이저에 대해 잘 아는 일부 고대인들은 그가 다시 돌아와 산 자와 죽은 자 모두를 지배할 날이 도래할까 봐 두려워합니다."),
            Profiles(R.drawable.morgana,"모르가나","Morgana","마법사","천상의 힘과 필멸의 육신 사이에서 고뇌하던 모르가나는 자신의 날개를 묶고 다시 인간의 삶을 살면서 부정하고 타락한 자들을 벌한다. 그녀는 데마시아의 부당한 법과 전통을 거부하며, 왕국의 그림자 속에서 암흑 불꽃으로 만든 방패와 사슬로 진실을 억압하려는 자들에 맞서 싸운다. 추방당하고 버림받은 자라고 해도 언젠가 다시 돌아올 수 있다고 믿기 때문이다."),
            Profiles(R.drawable.mundo,"문도 박사","DrMundo","탱커","완전히 미쳐버린 비참한 살인마이자 오싹한 보라색 괴물로 변한 문도 박사는 많은 자운 시민이 특히나 어두운 밤에 외출을 피하는 이유이다. 현재 의사를 자처하는 그는 한때 자운에서 가장 악명 높은 정신 병원에 수용된 환자였다. 모든 의료진을 '치료'하고 나서, 문도 박사는 자신이 치료받았던 빈 병원에서 의사가 된 뒤 본인이 수없이 당한 몹시 부도덕한 치료법을 따라 하기 시작했다. 의약품은 많지만 의학 지식은 전혀 없는 문도 박사는 약물을 주사할 때마다 더욱더 괴물처럼 변해 그의 진료실 주변을 헤매는 불운한 '환자'들을 두려움에 빠트린다."),
            Profiles(R.drawable.missfortune,"미스 포츈","MissFortune","원거리딜러","빌지워터의 선장 사라 포츈은 미모로도 유명하지만 무자비한 일처리 때문에 공포의 대상이기도 하다. 틀로 찍어낸 듯 똑같은 빌지워터의 범죄자들 사이에서 그녀는 단연 돋보이는 존재다. 어릴 적 자신의 가족이 해적왕 갱플랭크에게 살해당하는 것을 목격했고, 세월이 흐른 후 갱플랭크가 타고 있던 기함을 불태우는 것으로 잔혹한 복수극을 완성했다. 사라 포츈을 과소평가했다가는 그 매력에 가려진 예측불허의 실력에 기겁을 하거나... 배에 총알 구멍이 날 수도 있다.")
        )

        val profileList10 = arrayListOf(  // 리사이클뷰 더비 데이터
            // 10번째 줄
            Profiles(R.drawable.malphite,"","말파이트","탱커","")

        )


        //VERTICAL 세로 방향  HORIZONTAL 가로방향
        binding.rvProfile.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        binding.rvProfile.setHasFixedSize(true)
        binding.rvProfile.adapter = ProfileAdapter(profileList)

        binding.rvProfile2.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        binding.rvProfile2.setHasFixedSize(true)
        binding.rvProfile2.adapter = ProfileAdapter(profileList2)

        binding.rvProfile3.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        binding.rvProfile3.setHasFixedSize(true)
        binding.rvProfile3.adapter = ProfileAdapter(profileList3)

        binding.rvProfile4.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        binding.rvProfile4.setHasFixedSize(true)
        binding.rvProfile4.adapter = ProfileAdapter(profileList4)

        binding.rvProfile5.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        binding.rvProfile5.setHasFixedSize(true)
        binding.rvProfile5.adapter = ProfileAdapter(profileList5)

        binding.rvProfile6.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        binding.rvProfile6.setHasFixedSize(true)
        binding.rvProfile6.adapter = ProfileAdapter(profileList6)

        binding.rvProfile7.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        binding.rvProfile7.setHasFixedSize(true)
        binding.rvProfile7.adapter = ProfileAdapter(profileList7)

        binding.rvProfile8.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        binding.rvProfile8.setHasFixedSize(true)
        binding.rvProfile8.adapter = ProfileAdapter(profileList8)

        binding.rvProfile9.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        binding.rvProfile9.setHasFixedSize(true)
        binding.rvProfile9.adapter = ProfileAdapter(profileList9)

        // 네이게이션 이벤트
        binding.btnNavi.setOnClickListener(){
            binding.layoutDrawer.openDrawer(GravityCompat.START) // START : left  END : right
        }
        binding.navieView.setNavigationItemSelectedListener(this)



      binding.seletText.setOnEditorActionListener(getEditorActionListener(binding.seletImg)) // 키보드에서 done(완료)

        binding.seletImg.setOnClickListener {
            showToast("확인 버튼이 눌려졌습니다")
        }


    }


    fun getEditorActionListener(view: View): TextView.OnEditorActionListener { // 키보드에서 done(완료) 클릭 시 , 원하는 뷰 클릭되게 하는 메소드
        return TextView.OnEditorActionListener { textView, actionId, keyEvent ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                view.callOnClick()
            }
            false
        }
    }
    fun showToast(message: String) {
        Toast.makeText(applicationContext, message, Toast.LENGTH_LONG).show()
    }


    // 네이게이션 메뉴 아이템 클릭시 수행 메서드
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        val intent = Intent(this, LoginActivity::class.java) // 로그인 액티비티
        val intent2 = Intent(this, MainActivity::class.java) // 메인 액티비티
        val intent3 = Intent(this, My_Champion::class.java) // 챔피언 스펠 액티비티
        val intent4 = Intent(this, My_RuneActivity::class.java) // 챔피언 룬 액티비티
        val intent5 = Intent(this, My_ItemListActivity::class.java) // 챔피언 룬 액티비티


        when(item.itemId){
            R.id.login -> startActivity(intent)
            R.id.champion -> startActivity(intent2)
            R.id.championSpell -> startActivity(intent3)
            R.id.championRune -> startActivity(intent4)
            R.id.championItem -> startActivity(intent5)

            R.id.login -> Toast.makeText(applicationContext,"로그인",Toast.LENGTH_LONG).show()
            R.id.champion -> Toast.makeText(applicationContext,"챔피언 정보",Toast.LENGTH_LONG).show()
            R.id.championSpell -> Toast.makeText(applicationContext,"새소식",Toast.LENGTH_LONG).show()
        }
        binding.layoutDrawer.closeDrawers() //네이게이션 닫기
        return false
    }

    override fun onBackPressed() {
        if(binding.layoutDrawer.isDrawerOpen(GravityCompat.START)){
            binding.layoutDrawer.closeDrawers()
        }else{

        }
        super.onBackPressed()
    }
}
class MyAdapter(private val myDatset:List<String>) :
    RecyclerView.Adapter<MyAdapter.MyViewHolder>(){

    class MyViewHolder (itemView : View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent:ViewGroup,viewType:Int):MyAdapter.MyViewHolder{
        val textView = LayoutInflater.from(parent.context).inflate(R.layout.recycler_view,parent,false)as TextView
        return MyViewHolder(textView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val itemView = holder.itemView
        val textView =itemView.findViewById<TextView>(R.id.tv_time)
        textView.text = myDatset[position]

    }

    override fun getItemCount()= myDatset.size




  /*  // 네트워크를 이용할 때는 쓰레드를 사용해서 접근해야 함
    inner class NetworkThread: Thread(){
        override fun run() {

            // 키 값
            val key = "키값"

            // 현재 페이지번호
            val pageNo = "&pageNo=1"

            // 한 페이지 결과 수
            val numOfRows ="&numOfRows=10"

            // AND(안드로이드)
            val MobileOS = "&MobileOS=AND"

            // 서비스명 = 어플명
            val MobileApp = "&MobileApp=AppTest"

            // API 정보를 가지고 있는 주소
            val site = "http://api.visitkorea.or.kr/openapi/service/rest/GoCamping/basedList?serviceKey="+key+pageNo+numOfRows+MobileOS+MobileApp+"&_type=json"

            val url = URL(site)
            val conn = url.openConnection()
            val input = conn.getInputStream()
            val isr = InputStreamReader(input)
            // br: 라인 단위로 데이터를 읽어오기 위해서 만듦
            val br = BufferedReader(isr)

            // Json 문서는 일단 문자열로 데이터를 모두 읽어온 후, Json에 관련된 객체를 만들어서 데이터를 가져옴
            var str: String? = null
            val buf = StringBuffer()

            do{
                str = br.readLine()

                if(str!=null){
                    buf.append(str)
                }
            }while (str!=null)

            // 전체가 객체로 묶여있기 때문에 객체형태로 가져옴
            val root = JSONObject(buf.toString())
            val response = root.getJSONObject("response").getJSONObject("body").getJSONObject("items")
            val item = response.getJSONArray("item") // 객체 안에 있는 item이라는 이름의 리스트를 가져옴

            // 화면에 출력
            runOnUiThread {

                // 페이지 수만큼 반복하여 데이터를 불러온다.
                for(i in 0 until item.length()){

                    // 쪽수 별로 데이터를 읽는다.
                    val jObject = item.getJSONObject(i)

                    textView.append("${i + 1}번 캠핑장 \n")
                    textView.append("1. 주소: ${ JSON_Parse(jObject,"addr1")}\n")
                    textView.append("2. 캠핑장 이름: ${JSON_Parse(jObject,"facltNm")}\n")
                    textView.append("3. 업종: ${JSON_Parse(jObject,"induty")}\n")
                    textView.append("4. 전화번호: ${ JSON_Parse(jObject,"tel")}\n")
                    textView.append("5. 경도: ${JSON_Parse(jObject,"mapX")}\n")
                    textView.append("6. 위도: ${JSON_Parse(jObject,"mapY")}\n")
                }
            }
        }

        // 함수를 통해 데이터를 불러온다.
        fun JSON_Parse(obj:JSONObject, data : String): String {

            // 원하는 정보를 불러와 리턴받고 없는 정보는 캐치하여 "없습니다."로 리턴받는다.
            return try {

                obj.getString(data)

            } catch (e: Exception) {
                "없습니다."
            }
        }
    }*/



}