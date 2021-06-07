import {Drawer, Input, Col, Select, Form, Row, Button, Spin} from 'antd';

import { addNewPlayer} from "./client";
import {LoadingOutlined} from "@ant-design/icons";
import {useState} from "react";
import {successNotification, errorNotification} from "./Notification";

const antIcon = <LoadingOutlined style={{ fontSize: 24 }} spin />;

const {Option} = Select;

function AddPlayerForm({showDrawer, setShowDrawer, fetchGames}) {
    const onCLose = () => setShowDrawer(false);
    const [submitting, setSubmitting] = useState(false)

    const onFinish = player => {
        setSubmitting(true)
        console.log(JSON.stringify(player, null, 2))
        addNewPlayer(player)
            .then(() => {
                onCLose();
                successNotification("Game Over!!",
                    "See results in below table now!")
                fetchGames()
            }).catch(err => {
                errorNotification("Error while playing RPS!" + err)
                console.log(err)
        }).finally(() =>
            { setSubmitting(false)})
    };

    const onFinishFailed = errorInfo => {
        alert(JSON.stringify(errorInfo, null, 2));
    };

    return <Drawer
        title="Play! Rock Paper Scissor with your computer!"
        width={720}
        onClose={onCLose}
        visible={showDrawer}
        bodyStyle={{paddingBottom: 80}}
        footer={
            <div
                style={{
                    textAlign: 'right',
                }}
            >
                <Button onClick={onCLose} style={{marginRight: 8}}>
                    Cancel
                </Button>
            </div>
        }
    >
        <Form layout="vertical"
              onFinishFailed={onFinishFailed}
              onFinish={onFinish}
              hideRequiredMark>
            <Row gutter={16}>
                <Col span={18}>
                    <Form.Item
                        name="shape"
                        label="Please enter your shape. Accepting values R,P or S"
                        rules={[{required: true, message: 'Please enter your shape. Accepting values R,P or S'}]}
                    >
                        <Input placeholder="R, P or S"/>
                    </Form.Item>
                </Col>
            </Row>

            <Row>
                <Col span={12}>
                    <Form.Item >
                        <Button type="primary" htmlType="submit">
                            Submit
                        </Button>
                    </Form.Item>
                </Col>
            </Row>
            <Row>
                {submitting && <Spin indicator={antIcon} />}
            </Row>
        </Form>
    </Drawer>
}

export default AddPlayerForm;
