import './App.css';
import {useState, useEffect} from "react";
import { getAllGames } from "./client.js"
import {
    DesktopOutlined,
    PieChartOutlined,
    FileOutlined,
    TeamOutlined,
    UserOutlined, LoadingOutlined, DownloadOutlined, PlusOutlined,
} from '@ant-design/icons';
import {Table, Layout, Menu, Breadcrumb, Spin, Empty, Button, Badge, Tag} from 'antd';
import AddPlayerForm from "./AddPlayerForm";

const { Header, Content, Footer, Sider } = Layout;
const { SubMenu } = Menu;

const columns = [
    {
        title: 'Game Id',
        dataIndex: 'id',
        key: 'id',
    },
    {
        title: 'Player Name',
        dataIndex: ["player", "name"],
        key: ["player", "name"],
    },
    {
        title: 'Player Shape',
        dataIndex: 'playerShape',
        key: 'playerShape',
    },
    {
        title: 'Computer Shape',
        dataIndex: 'computerShape',
        key: 'computerShape',
    },
    {
        title: 'Results',
        dataIndex: 'gameResults',
        key: 'gameResults',
    },
];


const antIcon = <LoadingOutlined style={{ fontSize: 24 }} spin />;


function App() {

    const [games, setGames] = useState([]);
    const [collapsed, setCollapsed] = useState(false);
    const [fetching, setFetching] = useState(true);
    const [showDrawer, setShowDrawer] = useState(false);
    const [userID, setUserId] = useState(1)



    const fetchGames = () =>getAllGames()
        .then(response => response.json())
        .then(data => {
            console.log(data);
            setGames(data);
            setFetching(false)
        })
    const getDefaultUserId = () => {
        return userID;
    }


    useEffect((() =>{
        console.log("Component is mounted")
        fetchGames();
    }), []);

    const renderGames = () => {
        if(fetching) {
            return <Spin indicator={antIcon} />
        }


        return <>
            <AddPlayerForm showDrawer={showDrawer}
                           setShowDrawer={setShowDrawer}
                           fetchGames = {fetchGames}
            />

            <Table
                dataSource={games}
                columns={columns}
                bordered
                title={() =>
                    <>
                    <Button type="primary"
                            onClick={() => setShowDrawer(!showDrawer)}
                            shape="round" icon={<PlusOutlined/>} size="large">
                        Play New Game
                    </Button>
                    <Tag style = {{marginLeft: "15px"}}>Game Count</Tag>
                    <Badge count={games.length} className="site-badge-count-4"/>
                    </>
                }
                rowKey={(student)=> student.id}
            />
            </>

    }

    return <Layout style={{ minHeight: '100vh' }}>

        <Layout className="site-layout">
            <Header className="site-layout-background" style={{ padding: 0 }} />
            <Content style={{ margin: '0 16px' }}>
                <Breadcrumb style={{ margin: '16px 0' }}>
                    <Breadcrumb.Item>User</Breadcrumb.Item>
                    <Breadcrumb.Item>Default Player - User ID {getDefaultUserId()}</Breadcrumb.Item>
                </Breadcrumb>
                <div className="site-layout-background" style={{ padding: 24, minHeight: 360 }}>
                    {renderGames()}
                </div>
            </Content>
            <Footer style={{ textAlign: 'center' }}>Ant Design ©2018 Created by Ant UED</Footer>
        </Layout>
    </Layout>
}

export default App;
