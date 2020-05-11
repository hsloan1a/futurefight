import React from 'react'

import {Col, Container, Row} from "react-bootstrap";
import LevelList from "./level/LevelList";
import {Level} from "./model/Level";
import axios from "axios";
import {map, uniq, filter} from "underscore"
import LevelListDetail from "./level/LevelListDetail";
import CharacterList from "../character/CharacterList";
import {Character} from "./model/Character";

type ShadowLandState = {
    currentLevel: number,
    levelList: number[],
    allLevels: number[],
    allCharcters: Character[]
}

class ShadowLandApp extends React.Component<any, any> {
    state = {
        currentLevel: 1,
        levelList: [1],
        allLevels: [],
        allCharacters: []

    }

    private setLevel = (currentLevel: number) => {
        console.log(currentLevel)
        this.setState({currentLevel});
    }

    private addLevel = (level: Level) => {
        axios.post(process.env.REACT_APP_APP_BACKEND_BASEURL + 'shadowland/level/', level).then((response) => {
            console.log(response);
        })
    }

    private deleteLevel = (levelId: number) => {
        const deleteUrl = 'shadowland/level/' + String(levelId)
        axios.delete(process.env.REACT_APP_APP_BACKEND_BASEURL + deleteUrl).then((response) => {
            console.log(response);
        })
    }

    componentDidMount = (): void => {
        axios.get(process.env.REACT_APP_APP_BACKEND_BASEURL + 'shadowland/level/').then((response) => {
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
                    <Col sm={4}>
                        <LevelList
                        levelList={this.state.levelList}
                        setLevel={this.setLevel}
                        currentLevel={this.state.currentLevel}
                        />
                    </Col>
                    <Col>
                        <LevelListDetail
                        levelList={this.state.allLevels.length >= 0 ?
                            filter(this.state.allLevels, (level:Level) => level.level === this.state.currentLevel) : []
                        }
                        createLevel={this.addLevel}
                        currentSelectedLevel={this.state.currentLevel}
                        deleteLevel={this.deleteLevel}
                        />
                    </Col>
                </Row>
                <Row>
                    <CharacterList />
                </Row>
            </Container>
        )
    }
}

export default ShadowLandApp;