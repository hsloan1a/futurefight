import React from 'react'

import {Col, Container, Row} from "react-bootstrap";
import LevelList from "./LevelList";

class ShadowLandApp extends React.Component {

    componentDidMount(): void {
    }

    render() {
        return (
            <Container>
                <Row>
                    <Col><LevelList></LevelList></Col>
                    <Col>2 of 2</Col>
                </Row>
            </Container>
        )
    }
}

export default ShadowLandApp;