import React from 'react';
import { shallow, mount } from 'enzyme';
import CohortDetails from '../components/CohortDetails';
import { CohortData } from '../components/Cohort';
import renderer from 'react-test-renderer';

describe("Cohort Details Component", () => {
  const sampleCohort = CohortData[0];

  test("should create the component", () => {
    const wrapper = shallow(<CohortDetails />);
    expect(wrapper.exists()).toBe(true);
  });

  test("should initialize the props", () => {
    const wrapper = mount(<CohortDetails cohort={sampleCohort} />);
    expect(wrapper.props().cohort).toEqual(sampleCohort);
  });

  test("should display cohort code in h3", () => {
    const wrapper = mount(<CohortDetails cohort={sampleCohort} />);
    expect(wrapper.find('h3').text()).toContain(sampleCohort.code);
  });

  test("should always render same html", () => {
    const tree = renderer.create(<CohortDetails cohort={sampleCohort} />).toJSON();
    expect(tree).toMatchSnapshot();
  });
});
