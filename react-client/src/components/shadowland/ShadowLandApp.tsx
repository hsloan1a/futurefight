import React from 'react'

import {Col, Container, Row} from "react-bootstrap";
import LevelList from "./level/LevelList";
import {Level} from "./model/Level";
import axios from "axios";
import {map, uniq, filter} from "underscore"
import LevelListDetail from "./level/LevelListDetail";

class ShadowLandApp extends React.Component {
    state = {
        currentLevel: 1,
        levelList: [1],
        allLevels: []

    }

    private setLevel = (currentLevel: number) => {
        console.log(currentLevel)
        this.setState({currentLevel});
    }

    private addLevel = (level: Level) => {
        axios.post('shadowland/level/', level).then((response) => {
            console.log(response);
        })
    }

    componentDidMount = (): void => {
        axios.get('shadowland/level/').then((response) => {
            console.log(response);
            if (response.data) {
                let levelList = uniq(map(response.data, (level: Level) => {return level.level}));
                this.setState({levelList, allLevels: response.data});

            }
        })
    }

    render = () => {
        return (
            <Container>
                <Row>
                    <Col>
                        <LevelList
                        levelList={this.state.levelList}
                        setLevel={this.setLevel}
                        />
                    </Col>
                    <Col>
                        <LevelListDetail
                        levelList={this.state.allLevels.length >= 0 ?
                            filter(this.state.allLevels, (level:Level) => level.level === this.state.currentLevel) : []
                        }
                        createLevel={this.addLevel}
                        currentSelectedLevel={this.state.currentLevel}
                        />
                    </Col>
                </Row>
            </Container>
        )
    }
}

export default ShadowLandApp;